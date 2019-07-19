package fr.legrand.daifen.application.data.entity.model

import fr.legrand.daifen.application.data.values.TroopType

data class Troop(
    val troopType : TroopType,
    val count : Int
)