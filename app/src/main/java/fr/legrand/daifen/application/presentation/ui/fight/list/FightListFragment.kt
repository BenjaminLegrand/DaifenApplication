package fr.legrand.daifen.application.presentation.ui.fight.list

import android.os.Bundle
import android.view.View
import fr.legrand.daifen.application.R
import fr.legrand.daifen.application.presentation.ui.base.BaseNavFragment
import fr.legrand.daifen.application.presentation.ui.fight.list.navigator.FightListFragmentNavigatorListener
import fr.legrand.daifen.application.presentation.extensions.observeSafe
import org.koin.androidx.viewmodel.ext.android.viewModel

class FightListFragment : BaseNavFragment<FightListFragmentNavigatorListener>() {

    override val navListenerClass = FightListFragmentNavigatorListener::class

    private val viewModel: FightListFragmentViewModel by viewModel()

    override fun getLayoutId(): Int = R.layout.fragment_fight_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.viewState.observeSafe(this){

        }

        viewModel.fightList.observeSafe(this){

        }
    }
}