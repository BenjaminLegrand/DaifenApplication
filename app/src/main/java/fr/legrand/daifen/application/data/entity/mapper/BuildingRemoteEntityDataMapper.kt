package fr.legrand.daifen.application.data.entity.mapper

import fr.legrand.daifen.application.data.entity.model.Building
import fr.legrand.daifen.application.data.entity.remote.BuildingRemoteEntity
import fr.legrand.daifen.application.data.exception.MappingException

class BuildingRemoteEntityDataMapper {

    fun transform(remotes: List<BuildingRemoteEntity>): List<Building> {
        return remotes.mapNotNull {
            try {
                transform(it)
            } catch (e: MappingException) {
                null
            }
        }
    }

    fun transform(remote: BuildingRemoteEntity): Building {
        try {
            return Building(
                remote.buildingType,
                remote.count
            )
        } catch (e: Exception) {
            throw MappingException()
        }
    }
}