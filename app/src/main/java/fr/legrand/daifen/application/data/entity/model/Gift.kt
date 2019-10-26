package fr.legrand.daifen.application.data.entity.model

import fr.legrand.daifen.application.data.values.TroopType

data class Gift(
    val troopType: TroopType,
    val target: String,
    val count: Int
)
