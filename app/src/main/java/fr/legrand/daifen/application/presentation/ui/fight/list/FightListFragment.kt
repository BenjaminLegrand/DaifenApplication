package fr.legrand.daifen.application.presentation.ui.fight.list

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import fr.legrand.daifen.application.R
import fr.legrand.daifen.application.presentation.extensions.hide
import fr.legrand.daifen.application.presentation.extensions.observeSafe
import fr.legrand.daifen.application.presentation.extensions.show
import fr.legrand.daifen.application.presentation.ui.base.BaseNavFragment
import fr.legrand.daifen.application.presentation.ui.fight.list.navigator.FightListFragmentNavigatorListener
import fr.legrand.daifen.application.presentation.ui.fight.list.ui.FightListAdapter
import kotlinx.android.synthetic.main.fragment_fight_list.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class FightListFragment : BaseNavFragment<FightListFragmentNavigatorListener>() {

    override val navListenerClass = FightListFragmentNavigatorListener::class

    private val viewModel: FightListFragmentViewModel by viewModel()
    private val adapter: FightListAdapter by inject()

    override fun getLayoutId(): Int = R.layout.fragment_fight_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragment_fight_list_recycler.layoutManager = LinearLayoutManager(requireContext())
        fragment_fight_list_recycler.adapter = adapter
        adapter.onItemClickListener = navigatorListener::displayFightDetail

        fragment_fight_list_swipe_refresh.setOnRefreshListener { viewModel.retrieveFightList() }


        viewModel.viewState.observeSafe(this) {
            fragment_fight_list_swipe_refresh.isRefreshing = it.loading
            if (it.displayPlaceholder) {
                fragment_fight_list_recycler.hide()
                fragment_fight_list_placeholder.show()
            } else {
                fragment_fight_list_recycler.show()
                fragment_fight_list_placeholder.hide()
            }
        }

        viewModel.fightList.observeSafe(this) {
            adapter.setItemList(it)
        }
    }
}