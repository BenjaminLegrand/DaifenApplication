package fr.legrand.daifen.application

import android.app.Application
import fr.legrand.daifen.application.data.di.dataModules
import fr.legrand.daifen.application.presentation.di.presentationModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DFApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            // Android context
            androidContext(this@DFApplication)
            // modules
            modules(presentationModules + dataModules)
        }
    }
}