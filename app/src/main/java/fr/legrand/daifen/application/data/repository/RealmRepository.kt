package fr.legrand.daifen.application.data.repository

import fr.legrand.daifen.application.data.entity.mapper.RealmRemoteEntityDataMapper
import fr.legrand.daifen.application.data.entity.model.Realm
import fr.legrand.daifen.application.data.manager.api.ApiManager
import io.reactivex.Single

class RealmRepository(
    private val apiManager: ApiManager,
    private val realmRemoteEntityDataMapper: RealmRemoteEntityDataMapper
) {
    fun getRealm(): Single<Realm> = Single.defer {
        apiManager.getRealm().map {
            realmRemoteEntityDataMapper.transform(it)
        }
    }
}