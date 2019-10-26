package fr.legrand.daifen.application.data.entity.model

import fr.legrand.daifen.application.data.values.BuildingType

data class Building(
    val buildingType: BuildingType,
    val count: Int,
    var attack: Int = 0,
    var resistance: Int = 0,
    var goldIncome: Int = 0,
    var intellectIncome: Int = 0
)
