package fr.legrand.daifen.application.data.entity.model

import fr.legrand.daifen.application.data.values.TroopType

data class Support(
    val troops: Map<TroopType, Int>,
    val target: String
)
