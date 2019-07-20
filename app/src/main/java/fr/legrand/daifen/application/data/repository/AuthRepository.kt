package fr.legrand.daifen.application.data.repository

import fr.legrand.daifen.application.data.manager.api.ApiManager
import fr.legrand.daifen.application.data.manager.prefs.SharedPrefsManager
import fr.legrand.daifen.application.data.manager.storage.StorageManager
import io.reactivex.Completable
import io.reactivex.Single

class AuthRepository(
    private val apiManager: ApiManager,
    private val sharedPrefsManager: SharedPrefsManager,
    private val storageManager: StorageManager
) {
    fun login(username: String, password: String): Completable = Completable.defer {
        apiManager.login(username, password)
    }.doOnComplete {
        storageManager.resetPigeonList()
    }

    fun checkLogin(): Single<Boolean> = Single.defer {
        Single.just(sharedPrefsManager.getAuthCookie() != null)
    }
}