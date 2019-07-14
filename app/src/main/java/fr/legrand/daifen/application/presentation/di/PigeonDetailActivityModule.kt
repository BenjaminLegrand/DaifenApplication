package fr.legrand.daifen.application.presentation.di

import androidx.navigation.findNavController
import fr.legrand.daifen.application.presentation.ui.base.BaseNavActivity
import fr.legrand.daifen.application.presentation.ui.pigeon.detail.PigeonDetailActivity
import fr.legrand.daifen.application.presentation.ui.pigeon.detail.navigator.PigeonDetailFragmentNavigatorListener
import fr.legrand.daifen.application.presentation.ui.pigeon.detail.navigator.PigeonDetailNavigator
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.named
import org.koin.dsl.module

val pigeonDetailActivityModule = module {
    scope(named<PigeonDetailActivity>()) {

        scoped { (activity: BaseNavActivity) ->
            activity.findNavController(activity.getNavHostId())
        }

        scoped<PigeonDetailFragmentNavigatorListener> { (activity: BaseNavActivity) ->
            get<PigeonDetailNavigator>(parameters = {
                parametersOf(
                    activity
                )
            })
        }

        scoped { (activity: BaseNavActivity) ->
            PigeonDetailNavigator(
                get(parameters = { parametersOf(activity) }),
                activity
            )
        }
    }
}