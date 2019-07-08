package fr.legrand.daifen.application.presentation.ui.pigeon.detail

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.navArgs
import fr.legrand.daifen.application.R
import fr.legrand.daifen.application.presentation.ui.base.BaseNavFragment
import fr.legrand.daifen.application.presentation.ui.pigeon.detail.navigator.PigeonDetailFragmentNavigatorListener
import fr.legrand.daifen.application.presentation.utils.observeSafe
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
            fragment_pigeon_detail_toolbar.title = it.getSubject()
            fragment_pigeon_detail_subject.text = it.getSubject()
            fragment_pigeon_detail_emitter.text = it.getEmitter()
            fragment_pigeon_detail_date.text = it.getDate(requireContext())

            it.getHistory().forEach {
                fragment_pigeon_detail_history.addView(TextView(requireContext()).apply {
                    text = it
                })
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