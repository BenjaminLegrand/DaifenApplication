package fr.legrand.daifen.application.presentation.ui.pigeon.detail

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
                .error(Glide.with(this).load(R.drawable.ic_launcher_background))
                .into(fragment_pigeon_detail_emitter_image)

            with(it.getHistory()) {
                if (isEmpty()) {
                    fragment_pigeon_detail_history_card.hide()
                } else {
                    forEach {
                        fragment_pigeon_detail_history.addView(PigeonHistoryItemView(requireContext()).apply {
                            bindItem(it)
                        })
                    }
                    fragment_pigeon_detail_history_card.show()
                }
            }
        }

        viewModel.errorEvent.observeSafe(this) {
            navigatorListener.finish()
        }

        viewModel.viewState.observeSafe(this) {
            if (it.loading) {
                //TODO
            } else {
                //TODO
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