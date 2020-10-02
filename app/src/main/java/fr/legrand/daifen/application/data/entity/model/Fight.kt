package fr.legrand.daifen.application.data.entity.model

import fr.legrand.daifen.application.data.values.FightType

data class Fight(
    val round: Int,
    val target: String,
    val type: FightType,
    val targetId: Int
)