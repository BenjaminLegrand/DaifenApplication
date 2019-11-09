package fr.legrand.daifen.application.presentation.di

import fr.legrand.daifen.application.presentation.component.error.ErrorComponent
import fr.legrand.daifen.application.presentation.component.error.ErrorComponentImpl
import fr.legrand.daifen.application.presentation.ui.fight.list.FightListFragmentViewModel
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
    viewModel { PigeonListFragmentViewModel(get()) }
    viewModel { PigeonDetailFragmentViewModel(get()) }
    viewModel { FightListFragmentViewModel(get()) }
    viewModel { OrdersFragmentViewModel(get()) }
    viewModel { RealmFragmentViewModel(get()) }
}

private val componentModule = module {
    single<ErrorComponent> { ErrorComponentImpl(get()) }
}

private val adapterModule = module {
    factory { PigeonListAdapter() }
}

val presentationModules = activityModules + viewModelModule + adapterModule + componentModule