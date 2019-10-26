package fr.legrand.daifen.application.presentation.di

import fr.legrand.daifen.application.presentation.ui.login.LoginFragmentViewModel
import fr.legrand.daifen.application.presentation.ui.order.OrdersFragmentViewModel
import fr.legrand.daifen.application.presentation.ui.pigeon.detail.PigeonDetailFragmentViewModel
import fr.legrand.daifen.application.presentation.ui.pigeon.list.PigeonListFragmentViewModel
import fr.legrand.daifen.application.presentation.ui.pigeon.list.ui.PigeonListAdapter
import fr.legrand.daifen.application.presentation.ui.realm.RealmFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private val activityModules = arrayOf(
    mainActivityModule,
    loginActivityModule,
    pigeonDetailActivityModule
)

private val viewModelModule = module {
    viewModel { LoginFragmentViewModel(get()) }
    viewModel {
        PigeonListFragmentViewModel(
            get()
        )
    }
    viewModel {
        PigeonDetailFragmentViewModel(
            get()
        )
    }
    viewModel { OrdersFragmentViewModel(get()) }
    viewModel { RealmFragmentViewModel(get()) }
}

private val adapterModule = module {
    factory { PigeonListAdapter() }
}

val presentationModules = activityModules + viewModelModule + adapterModule