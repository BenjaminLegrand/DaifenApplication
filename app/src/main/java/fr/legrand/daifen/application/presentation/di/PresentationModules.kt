package fr.legrand.daifen.application.presentation.di

import fr.legrand.daifen.application.presentation.ui.login.LoginFragmentViewModel
import fr.legrand.daifen.application.presentation.ui.pigeon.PigeonListFragmentViewModel
import fr.legrand.daifen.application.presentation.ui.pigeon.ui.PigeonListAdapter
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private val activityModules = arrayOf(
        mainActivityModule,
        loginActivityModule
)

private val viewModelModule = module {
    viewModel { LoginFragmentViewModel(get()) }
    viewModel { PigeonListFragmentViewModel(get()) }
}

private val adapterModule = module {
    factory { PigeonListAdapter() }
}

val presentationModules = activityModules + viewModelModule + adapterModule