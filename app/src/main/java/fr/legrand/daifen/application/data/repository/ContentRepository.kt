package fr.legrand.daifen.application.data.repository

import fr.legrand.daifen.application.data.entity.mapper.PigeonRemoteEntityDataMapper
import fr.legrand.daifen.application.data.entity.model.Pigeon
import fr.legrand.daifen.application.data.manager.api.ApiManager
import fr.legrand.daifen.application.data.manager.prefs.SharedPrefsManager
import io.reactivex.Single

class ContentRepository(
    private val sharedPrefsManager: SharedPrefsManager,
    private val apiManager: ApiManager,
    private val pigeonRemoteEntityDataMapper: PigeonRemoteEntityDataMapper
) {
    fun getPigeonList(): Single<List<Pigeon>> = apiManager.getPigeonList(sharedPrefsManager.getAuthCookie()).map {
        pigeonRemoteEntityDataMapper.transform(it)
    }
}