package fr.legrand.daifen.application.data.manager.api

import fr.legrand.daifen.application.data.entity.remote.PigeonRemoteEntity
import io.reactivex.Single

interface ApiManager {
    fun getPigeonList(authCookie: String): Single<List<PigeonRemoteEntity>>
    fun login(username: String, password: String): Single<String>
}