package fr.legrand.daifen.application.data.di

import android.app.NotificationManager
import android.content.Context
import androidx.work.WorkManager
import com.google.gson.GsonBuilder
import fr.legrand.daifen.application.BuildConfig
import fr.legrand.daifen.application.data.component.background.BackgroundComponent
import fr.legrand.daifen.application.data.component.background.BackgroundComponentImpl
import fr.legrand.daifen.application.data.component.notification.NotificationComponent
import fr.legrand.daifen.application.data.component.notification.NotificationComponentImpl
import fr.legrand.daifen.application.data.entity.mapper.*
import fr.legrand.daifen.application.data.manager.api.ApiManager
import fr.legrand.daifen.application.data.manager.api.ApiManagerImpl
import fr.legrand.daifen.application.data.manager.api.ApiService
import fr.legrand.daifen.application.data.manager.api.NetworkInterceptor
import fr.legrand.daifen.application.data.manager.prefs.SharedPrefsManager
import fr.legrand.daifen.application.data.manager.prefs.SharedPrefsManagerImpl
import fr.legrand.daifen.application.data.manager.storage.StorageManager
import fr.legrand.daifen.application.data.manager.storage.StorageManagerImpl
import fr.legrand.daifen.application.data.repository.AuthRepository
import fr.legrand.daifen.application.data.repository.OrdersRepository
import fr.legrand.daifen.application.data.repository.PigeonRepository
import fr.legrand.daifen.application.data.repository.RealmRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import pl.droidsonroids.retrofit2.JspoonConverterFactory
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

val managerModule = module {
    single<ApiManager> { ApiManagerImpl(get()) }
    single<SharedPrefsManager> { SharedPrefsManagerImpl(get()) }
    single<StorageManager> { StorageManagerImpl(get()) }
}
val repositoryModule = module {
    single { AuthRepository(get(), get(), get()) }
    single { PigeonRepository(get(), get(), get(), get(), get()) }
    single { OrdersRepository(get(), get()) }
    single { RealmRepository(get(), get()) }
}

val mapperModule = module {
    single { PigeonRemoteEntityDataMapper(get()) }
    single { PigeonDBEntityDataMapper() }

    single { PlayerRemoteEntityDataMapper() }

    single { AttackRemoteEntityDataMapper() }
    single { BuildingRemoteEntityDataMapper() }
    single { GiftRemoteEntityDataMapper() }
    single { SpecialTroopRemoteEntityDataMapper() }
    single { SupportRemoteEntityDataMapper() }
    single { TroopRemoteEntityDataMapper() }
    single { OrderRemoteEntityDataMapper(get(), get(), get(), get(), get(), get()) }
    single { RealmRemoteEntityDataMapper(get(), get(), get(), get()) }
    single { RealmBuildingRemoteEntityDataMapper() }
    single { RealmTroopRemoteEntityDataMapper() }
    single { RealmKnowledgeRemoteEntityDataMapper() }
    single { RealmPlayerRemoteEntityDataMapper() }
}

val networkModule = module {
    single {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(JspoonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(get())
            .build()
    }
    single {
        get<Retrofit>().create(ApiService::class.java)
    }
    single {
        OkHttpClient.Builder().followRedirects(false)
            .addInterceptor(NetworkInterceptor(get(), get()))
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    }
}

val generalModule = module {
    single { GsonBuilder().create() }
    single { WorkManager.getInstance(get()) }
    single { get<Context>().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager }
}

val componentModule = module {
    single<BackgroundComponent> {
        BackgroundComponentImpl(get())
    }
    single<NotificationComponent> {
        NotificationComponentImpl(get(), get())
    }
}

val dataModules =
    managerModule + networkModule + repositoryModule + mapperModule + generalModule + componentModule