package fr.legrand.daifen.application.data.entity.remote

import fr.legrand.daifen.application.data.values.BuildingType

data class BuildingRemoteEntity(
    val buildingType: BuildingType,
    val count: Int
)
