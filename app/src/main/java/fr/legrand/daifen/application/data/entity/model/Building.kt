package fr.legrand.daifen.application.data.entity.model

import fr.legrand.daifen.application.data.values.BuildingType

data class Building(
    val buildingType: BuildingType,
    val count: Int
)
