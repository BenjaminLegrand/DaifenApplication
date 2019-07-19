package fr.legrand.daifen.application.data.entity.remote

import fr.legrand.daifen.application.data.values.SpecialTroopActionType
import fr.legrand.daifen.application.data.values.SpecialTroopType

data class SpecialTroopRemoteEntity(
    val specialTroopType: SpecialTroopType,
    val specialTroopAction: SpecialTroopActionType
)