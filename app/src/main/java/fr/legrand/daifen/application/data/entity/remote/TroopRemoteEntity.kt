package fr.legrand.daifen.application.data.entity.remote

import fr.legrand.daifen.application.data.values.TroopType

data class TroopRemoteEntity(
    val troopType : TroopType,
    val count : Int
)