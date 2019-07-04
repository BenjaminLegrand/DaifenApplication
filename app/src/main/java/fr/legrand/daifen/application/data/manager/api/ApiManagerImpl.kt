package fr.legrand.daifen.application.data.manager.api

import fr.legrand.daifen.application.data.entity.remote.PigeonRemoteEntity
import fr.legrand.daifen.application.data.exception.AuthenticationException
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.HttpException


private const val HTTP_REDIRECT_CODE = 302

class ApiManagerImpl(private val apiService: ApiService) : ApiManager {

    override fun getPigeonList(authCookie: String): Single<List<PigeonRemoteEntity>> =
            apiService.getPigeonList(authCookie).map {
                it.pigeonRemoteList
            }.addRedirectCheck()

    override fun login(username: String, password: String): Completable =
            apiService.login(username, password).addRedirectCheck().ignoreElement()

    private fun <T> Single<T>.addRedirectCheck(): Single<T> {
        return onErrorResumeNext {
            if (it is HttpException && it.code() == HTTP_REDIRECT_CODE) {
                Single.error(AuthenticationException())
            } else {
                Single.error(it)
            }
        }
    }
}