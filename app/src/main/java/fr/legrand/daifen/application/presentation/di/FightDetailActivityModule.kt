package fr.legrand.daifen.application.presentation.di

import androidx.navigation.findNavController
import fr.legrand.daifen.application.presentation.ui.base.BaseNavActivity
import fr.legrand.daifen.application.presentation.ui.fight.detail.FightDetailActivity
import fr.legrand.daifen.application.presentation.ui.fight.detail.navigator.FightDetailFragmentNavigatorListener
import fr.legrand.daifen.application.presentation.ui.fight.detail.navigator.FightDetailNavigator
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.named
import org.koin.dsl.module

val fightDetailActivityModule = module {
    scope(named<FightDetailActivity>()) {

        scoped { (activity: BaseNavActivity) ->
            activity.findNavController(activity.getNavHostId())
        }

        scoped<FightDetailFragmentNavigatorListener> { (activity: BaseNavActivity) ->
            get<FightDetailNavigator>(parameters = {
                parametersOf(
                    activity
                )
            })
        }

        scoped { (activity: BaseNavActivity) ->
            FightDetailNavigator(
                get(parameters = { parametersOf(activity) }),
                activity
            )
        }
    }
}