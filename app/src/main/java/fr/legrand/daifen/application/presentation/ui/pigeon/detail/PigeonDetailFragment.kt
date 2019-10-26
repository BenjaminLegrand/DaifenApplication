package fr.legrand.daifen.application.presentation.ui.pigeon.detail

import android.animation.AnimatorInflater
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import fr.legrand.daifen.application.R
import fr.legrand.daifen.application.presentation.ui.base.BaseNavFragment
import fr.legrand.daifen.application.presentation.ui.pigeon.detail.navigator.PigeonDetailFragmentNavigatorListener
import fr.legrand.daifen.application.presentation.ui.pigeon.detail.ui.PigeonHistoryItemView
import fr.legrand.daifen.application.presentation.utils.hide
import fr.legrand.daifen.application.presentation.utils.observeSafe
import fr.legrand.daifen.application.presentation.utils.show
import kotlinx.android.synthetic.main.fragment_pigeon_detail.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class PigeonDetailFragment : BaseNavFragment<PigeonDetailFragmentNavigatorListener>() {
    override val navListenerClass = PigeonDetailFragmentNavigatorListener::class

    override fun getLayoutId(): Int = R.layout.fragment_pigeon_detail

    private val args by navArgs<PigeonDetailFragmentArgs>()
    private val viewModel: PigeonDetailFragmentViewModel by viewModel()

    private lateinit var rotateExpandAnimator: ObjectAnimator
    private lateinit var rotateCollapseAnimator: ObjectAnimator

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rotateExpandAnimator =
            AnimatorInflater.loadAnimator(context, R.animator.rotate_expand) as ObjectAnimator
        rotateCollapseAnimator =
            AnimatorInflater.loadAnimator(context, R.animator.rotate_collapse) as ObjectAnimator
        rotateExpandAnimator.target = fragment_pigeon_detail_history_toggle
        rotateCollapseAnimator.target = fragment_pigeon_detail_history_toggle

        setHasOptionsMenu(true)
        (activity as AppCompatActivity).setSupportActionBar(fragment_pigeon_detail_toolbar)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

        viewModel.getPigeon(args.pigeonId)

        viewModel.pigeon.observeSafe(this) {
            fragment_pigeon_detail_collapsible_toolbar.title = it.getEmitter()
            fragment_pigeon_detail_subject.text = it.getSubject()
            fragment_pigeon_detail_date.text = it.getDate(requireContext())
            fragment_pigeon_detail_content.text = it.getContent()
            Glide.with(this).load(it.getEmitterImageUrl())
                .error(Glide.with(this).load(R.drawable.daifen_login_logo))
                .apply(RequestOptions.circleCropTransform())
                .into(fragment_pigeon_detail_emitter_image)

            with(it.getHistory()) {
                if (isEmpty()) {
                    fragment_pigeon_detail_history_group.hide()
                    fragment_pigeon_detail_history.hide()
                } else {
                    forEach {
                        fragment_pigeon_detail_history.addView(PigeonHistoryItemView(requireContext()).apply {
                            bindItem(it)
                        })
                    }
                    fragment_pigeon_detail_history_group.show()
                }
            }
        }

        viewModel.errorEvent.observeSafe(this) {
            navigatorListener.finish()
        }

        viewModel.viewState.observeSafe(this) {
            if (it.loading) {
                fragment_pigeon_detail_content_group.hide()
                fragment_pigeon_detail_progress.show()
            } else {
                fragment_pigeon_detail_content_group.show()
                fragment_pigeon_detail_progress.hide()
            }
        }

        fragment_pigeon_detail_history_collapse_area.setOnClickListener {
            if (fragment_pigeon_detail_history.isVisible) {
                fragment_pigeon_detail_history.hide()
                rotateExpandAnimator.cancel()
                rotateCollapseAnimator.start()
            } else {
                fragment_pigeon_detail_history.show()
                rotateCollapseAnimator.cancel()
                rotateExpandAnimator.start()
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> navigatorListener.finish()
        }
        return true
    }

}