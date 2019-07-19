package fr.legrand.daifen.application.data.entity.remote

import fr.legrand.daifen.application.data.values.TroopType

data class GiftRemoteEntity(
    val troopType: TroopType,
    val target: String,
    val count: Int
)
