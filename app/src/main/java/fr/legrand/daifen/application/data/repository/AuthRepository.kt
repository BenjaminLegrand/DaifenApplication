package fr.legrand.daifen.application.data.repository

import fr.legrand.daifen.application.data.exception.NoAuthCookieException
import fr.legrand.daifen.application.data.manager.api.ApiManager
import fr.legrand.daifen.application.data.manager.prefs.SharedPrefsManager
import fr.legrand.daifen.application.data.manager.storage.StorageManager
import io.reactivex.Single

class AuthRepository(
    private val apiManager: ApiManager,
    private val sharedPrefsManager: SharedPrefsManager,
    private val storageManager: StorageManager
) {
    fun login(username: String, password: String): Single<Boolean> = Single.defer {
        apiManager.login(username, password).andThen(apiManager.checkUserInGame())
    }.doOnSuccess {
        storageManager.resetPigeonList()
    }

    fun checkLoginAndUserInGame(): Single<Boolean> = Single.defer {
        if (sharedPrefsManager.getAuthCookie() == null) {
            return@defer Single.error<Boolean>(NoAuthCookieException())
        } else {
            return@defer apiManager.checkUserInGame()
        }
    }
}