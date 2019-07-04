package fr.legrand.daifen.application.presentation.di

import androidx.navigation.findNavController
import fr.legrand.daifen.application.presentation.ui.base.BaseNavActivity
import fr.legrand.daifen.application.presentation.ui.login.LoginActivity
import fr.legrand.daifen.application.presentation.ui.login.navigator.LoginFragmentNavigatorListener
import fr.legrand.daifen.application.presentation.ui.login.navigator.LoginNavigator
import fr.legrand.daifen.application.presentation.ui.main.navigator.MainNavigator
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.named
import org.koin.dsl.module

val loginActivityModule = module {
    scope(named<LoginActivity>()) {

        scoped { (activity: BaseNavActivity) ->
            activity.findNavController(activity.getNavHostId())
        }

        scoped<LoginFragmentNavigatorListener> { (activity: BaseNavActivity) ->
            get<LoginNavigator>(parameters = {
                parametersOf(
                    activity
                )
            })
        }

        scoped { (activity: BaseNavActivity) ->
            LoginNavigator(
                get(parameters = { parametersOf(activity) }),
                activity
            )
        }
    }
}