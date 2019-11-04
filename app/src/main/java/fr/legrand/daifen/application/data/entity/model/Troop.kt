package fr.legrand.daifen.application.data.entity.model

import fr.legrand.daifen.application.data.values.TroopType

data class Troop(
    val troopType: TroopType,
    val count: Int,
    var attack: Int = 0,
    var defense: Int = 0,
    var resistance: Int = 0,
    var gold: Int = 0,
    var intellect: Int = 0
)