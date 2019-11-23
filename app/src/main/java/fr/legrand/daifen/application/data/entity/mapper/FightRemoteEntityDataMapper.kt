package fr.legrand.daifen.application.data.entity.mapper

import fr.legrand.daifen.application.data.entity.model.Fight
import fr.legrand.daifen.application.data.entity.model.FightDetail
import fr.legrand.daifen.application.data.entity.remote.FightListItemRemoteEntity
import fr.legrand.daifen.application.data.entity.remote.FightRemoteEntity
import fr.legrand.daifen.application.data.exception.MappingException

class FightRemoteEntityDataMapper(
    private val playerRemoteEntityDataMapper: PlayerRemoteEntityDataMapper,
    private val troopRemoteEntityDataMapper: TroopRemoteEntityDataMapper,
    private val buildingRemoteEntityDataMapper: BuildingRemoteEntityDataMapper
) {

    fun transform(listItemRemotes: List<FightListItemRemoteEntity>): List<Fight> {
        return listItemRemotes.mapNotNull {
            try {
                transform(it)
            } catch (e: MappingException) {
                null
            }
        }
    }

    fun transform(remote: FightListItemRemoteEntity): Fight {
        try {
            return Fight(
                remote.round,
                remote.target,
                remote.type,
                remote.targetId
            )
        } catch (e: Exception) {
            throw MappingException()
        }
    }

    fun transform(remote: FightRemoteEntity): FightDetail {
        try {
            return FightDetail(
                playerRemoteEntityDataMapper.transform(remote.attackers),
                playerRemoteEntityDataMapper.transform(remote.defenders),
                troopRemoteEntityDataMapper.transform(remote.attackersTroops),
                troopRemoteEntityDataMapper.transform(remote.defendersTroops),
                troopRemoteEntityDataMapper.transform(remote.attackersLosses),
                troopRemoteEntityDataMapper.transform(remote.defendersLosses),
                buildingRemoteEntityDataMapper.transform(remote.destroyedBuildings)
            )
        } catch (e: Exception) {
            throw MappingException()
        }
    }
}