package fr.legrand.daifen.application.presentation.ui.pigeon.list

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import fr.legrand.daifen.application.R
import fr.legrand.daifen.application.data.exception.AuthenticationException
import fr.legrand.daifen.application.presentation.extensions.hide
import fr.legrand.daifen.application.presentation.extensions.observeSafe
import fr.legrand.daifen.application.presentation.extensions.show
import fr.legrand.daifen.application.presentation.ui.base.BaseNavFragment
import fr.legrand.daifen.application.presentation.ui.pigeon.list.navigator.PigeonListFragmentNavigatorListener
import fr.legrand.daifen.application.presentation.ui.pigeon.list.ui.PigeonListAdapter
import kotlinx.android.synthetic.main.fragment_pigeon_list.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class PigeonListFragment : BaseNavFragment<PigeonListFragmentNavigatorListener>() {

    override val navListenerClass = PigeonListFragmentNavigatorListener::class

    private val viewModel: PigeonListFragmentViewModel by viewModel()
    private val pigeonListAdapter: PigeonListAdapter by inject()

    override fun getLayoutId(): Int = R.layout.fragment_pigeon_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHasOptionsMenu(true)
        (activity as AppCompatActivity).setSupportActionBar(fragment_pigeon_list_toolbar)

        fragment_pigeon_list_recycler.adapter = pigeonListAdapter
        fragment_pigeon_list_recycler.layoutManager = LinearLayoutManager(requireContext())
        pigeonListAdapter.onItemClickListener = {
            viewModel.onPigeonClicked(it)
            navigatorListener.displayPigeonDetails(it)
        }
        fragment_pigeon_list_swipe_refresh.setOnRefreshListener { viewModel.getPigeonList() }

        viewModel.viewState.observeSafe(this) {
            fragment_pigeon_list_swipe_refresh.isRefreshing = it.loading
            if (it.displayPlaceholder) {
                fragment_pigeon_list_recycler.hide()
                fragment_pigeon_list_placeholder.show()
            } else {
                fragment_pigeon_list_recycler.show()
                fragment_pigeon_list_placeholder.hide()
            }
        }

        viewModel.errorEvent.observeSafe(this) {
            when (it) {
                is AuthenticationException -> navigatorListener.displayLoginActivity()
            }
        }

        viewModel.pigeonList.observeSafe(this) {
            pigeonListAdapter.setItemList(it)
        }
    }
}
