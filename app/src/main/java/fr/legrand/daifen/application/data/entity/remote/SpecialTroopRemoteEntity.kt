package fr.legrand.daifen.application.data.entity.remote

import fr.legrand.daifen.application.data.values.SpecialTroopActionType
import fr.legrand.daifen.application.data.values.TroopType

data class SpecialTroopRemoteEntity(
    val troopType: TroopType,
    val specialTroopAction: SpecialTroopActionType,
    val target: String,
    val showTarget: String
)