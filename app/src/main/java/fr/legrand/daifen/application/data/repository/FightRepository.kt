package fr.legrand.daifen.application.data.repository

import fr.legrand.daifen.application.data.entity.mapper.FightRemoteEntityDataMapper
import fr.legrand.daifen.application.data.entity.model.Fight
import fr.legrand.daifen.application.data.entity.model.FightDetail
import fr.legrand.daifen.application.data.manager.api.ApiManager
import io.reactivex.Single

class FightRepository(
    private val apiManager: ApiManager,
    private val fightRemoteEntityDataMapper: FightRemoteEntityDataMapper
) {
    fun retrieveFightList(): Single<List<Fight>> = apiManager.getFightList().map {
        fightRemoteEntityDataMapper.transform(it)
    }

    fun retrieveFight(round: Int, targetId : Int): Single<FightDetail>  = apiManager.getFight(round, targetId).map {
        fightRemoteEntityDataMapper.transform(it)
    }
}