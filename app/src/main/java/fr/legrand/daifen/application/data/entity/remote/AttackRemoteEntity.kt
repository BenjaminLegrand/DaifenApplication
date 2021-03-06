package fr.legrand.daifen.application.data.entity.remote

import fr.legrand.daifen.application.data.values.TroopType

data class AttackRemoteEntity(
    val troops: Map<TroopType, Int>,
    val target: String
)
