package fr.legrand.daifen.application.data.entity.model

import fr.legrand.daifen.application.data.values.SpecialTroopActionType
import fr.legrand.daifen.application.data.values.TroopType

data class SpecialTroop(
    val troopType: TroopType,
    val specialTroopAction: SpecialTroopActionType,
    val target: String,
    val showTarget: String
)