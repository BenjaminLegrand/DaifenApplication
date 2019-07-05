package fr.legrand.daifen.application.data.manager.api

import fr.legrand.daifen.application.data.entity.remote.PigeonRemoteEntity
import io.reactivex.Completable
import io.reactivex.Single

interface ApiManager {
    fun getPigeonList(): Single<List<PigeonRemoteEntity>>
    fun login(username: String, password: String): Completable
}