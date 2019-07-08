package fr.legrand.daifen.application.presentation.di

import androidx.navigation.findNavController
import fr.legrand.daifen.application.presentation.ui.base.BaseNavActivity
import fr.legrand.daifen.application.presentation.ui.main.MainActivity
import fr.legrand.daifen.application.presentation.ui.main.navigator.MainNavigator
import fr.legrand.daifen.application.presentation.ui.pigeon.list.navigator.PigeonListFragmentNavigatorListener
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.named
import org.koin.dsl.module

val mainActivityModule = module {
    scope(named<MainActivity>()) {

        scoped { (activity: BaseNavActivity) ->
            activity.findNavController(activity.getNavHostId())
        }

        scoped<PigeonListFragmentNavigatorListener> { (activity: BaseNavActivity) ->
            get<MainNavigator>(parameters = {
                parametersOf(
                        activity
                )
            })
        }

        scoped { (activity: BaseNavActivity) ->
            MainNavigator(
                    get(parameters = { parametersOf(activity) }),
                    activity
            )
        }
    }
}