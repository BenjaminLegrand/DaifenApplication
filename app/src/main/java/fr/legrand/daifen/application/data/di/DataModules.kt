package fr.legrand.daifen.application.data.di

import com.google.gson.GsonBuilder
import fr.legrand.daifen.application.BuildConfig
import fr.legrand.daifen.application.data.entity.mapper.PigeonRemoteEntityDataMapper
import fr.legrand.daifen.application.data.manager.api.ApiManager
import fr.legrand.daifen.application.data.manager.api.ApiManagerImpl
import fr.legrand.daifen.application.data.manager.api.ApiService
import fr.legrand.daifen.application.data.manager.api.NetworkInterceptor
import fr.legrand.daifen.application.data.manager.prefs.SharedPrefsManager
import fr.legrand.daifen.application.data.manager.prefs.SharedPrefsManagerImpl
import fr.legrand.daifen.application.data.repository.AuthRepository
import fr.legrand.daifen.application.data.repository.ContentRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import pl.droidsonroids.retrofit2.JspoonConverterFactory
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

val managerModule = module {
    single<ApiManager> { ApiManagerImpl(get()) }
    single<SharedPrefsManager> { SharedPrefsManagerImpl(get()) }
}
val repositoryModule = module {
    single { AuthRepository(get(), get()) }
    single { ContentRepository(get(), get(), get()) }
}

val mapperModule = module {
    single { PigeonRemoteEntityDataMapper() }
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
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build()
    }
}

val generalModule = module {
    single { GsonBuilder().create() }
}

val dataModules = managerModule + networkModule + repositoryModule + mapperModule + generalModule