package fr.legrand.daifen.application.data.entity.model

import fr.legrand.daifen.application.data.values.TroopType

data class Attack(
    val troops: Map<TroopType, Int>,
    val target: String
)
