package fr.legrand.daifen.application.data.entity.mapper

import fr.legrand.daifen.application.data.entity.model.Building
import fr.legrand.daifen.application.data.entity.remote.RealmBuildingRemoteEntity
import fr.legrand.daifen.application.data.exception.MappingException
import fr.legrand.daifen.application.data.values.BuildingType

class RealmBuildingRemoteEntityDataMapper {

    fun transform(remotes: List<RealmBuildingRemoteEntity>): List<Building> {
        return remotes.mapNotNull {
            try {
                transform(it)
            } catch (e: MappingException) {
                null
            }
        }
    }

    fun transform(remote: RealmBuildingRemoteEntity): Building {
        try {
            return Building(
                BuildingType.fromValue(remote.buildingType) ?: throw MappingException(),
                remote.count.toInt(),
                remote.attack.toInt(),
                remote.resistance.toInt(),
                remote.goldIncome.toInt(),
                remote.intellectIncome.toInt()
            )
        } catch (e: Exception) {
            throw MappingException()
        }
    }
}