package fr.legrand.daifen.application.data.manager.api

import fr.legrand.daifen.application.data.entity.remote.PigeonRemoteEntity
import fr.legrand.daifen.application.data.exception.AuthenticationException
import io.reactivex.Single

private const val COOKIE_HEADER_NAME = "set-cookie"

class ApiManagerImpl(private val apiService: ApiService) : ApiManager {

    override fun getPigeonList(authCookie: String): Single<List<PigeonRemoteEntity>> =
        apiService.getPigeonList(authCookie).map {
            emptyList<PigeonRemoteEntity>()
//            it.pigeonRemoteList
        }

    override fun login(username: String, password: String): Single<String> =
        apiService.login(username, password).map {
            it.headers().toMultimap()[COOKIE_HEADER_NAME]?.joinToString() ?: throw AuthenticationException()
        }
}