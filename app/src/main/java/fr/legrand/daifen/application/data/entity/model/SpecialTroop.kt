package fr.legrand.daifen.application.data.entity.model

import fr.legrand.daifen.application.data.values.SpecialTroopActionType
import fr.legrand.daifen.application.data.values.SpecialTroopType

data class SpecialTroop(
    val specialTroopType: SpecialTroopType,
    val specialTroopAction: SpecialTroopActionType
)