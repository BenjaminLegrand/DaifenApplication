package fr.legrand.daifen.application.data.repository

import fr.legrand.daifen.application.data.entity.mapper.FightRemoteEntityDataMapper
import fr.legrand.daifen.application.data.entity.model.Fight
import fr.legrand.daifen.application.data.entity.model.Player
import fr.legrand.daifen.application.data.entity.model.Troop
import fr.legrand.daifen.application.data.manager.api.ApiManager
import fr.legrand.daifen.application.data.values.FightType
import fr.legrand.daifen.application.data.values.ReferentialValues
import fr.legrand.daifen.application.data.values.TroopType
import io.reactivex.Single

class FightRepository(
    private val apiManager: ApiManager,
    private val fightRemoteEntityDataMapper: FightRemoteEntityDataMapper
) {
    fun retrieveFightList(): Single<List<Fight>> = apiManager.retrieveFightList().map {
        fightRemoteEntityDataMapper.transform(it)
    }

    fun retrieveFight(id: Int): Single<Fight>  = apiManager.retrieveFight(id).map {
        fightRemoteEntityDataMapper.transform(it)
    }
}