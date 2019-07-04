package fr.legrand.daifen.application.presentation.ui.pigeon

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import fr.legrand.daifen.application.R
import fr.legrand.daifen.application.data.exception.AuthenticationException
import fr.legrand.daifen.application.presentation.ui.base.BaseNavFragment
import fr.legrand.daifen.application.presentation.ui.pigeon.navigator.PigeonListFragmentNavigatorListener
import fr.legrand.daifen.application.presentation.ui.pigeon.ui.PigeonListAdapter
import fr.legrand.daifen.application.presentation.utils.hide
import fr.legrand.daifen.application.presentation.utils.observeSafe
import fr.legrand.daifen.application.presentation.utils.show
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

        fragment_pigeon_list_recycler.adapter = pigeonListAdapter
        fragment_pigeon_list_recycler.layoutManager = LinearLayoutManager(requireContext())

        viewModel.viewState.observeSafe(this) {
            if (it.loading) {
                fragment_pigeon_list_recycler.hide()
                fragment_pigeon_list_progress.show()
            } else {
                fragment_pigeon_list_recycler.show()
                fragment_pigeon_list_progress.hide()
            }
        }

        viewModel.errorEvent.observeSafe(this){
            when(it){
                is AuthenticationException -> navigatorListener.displayLoginActivity()
            }
        }

        viewModel.pigeonList.observeSafe(this) {
            pigeonListAdapter.setItemList(it)
        }
    }
}