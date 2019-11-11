package fr.legrand.daifen.application.data.entity.remote

import fr.legrand.daifen.application.data.values.FightType
import pl.droidsonroids.jspoon.annotation.Selector

data class FightRemoteEntity(
    @Selector("#id")
    var id: Int = 0,
    @Selector("#type")
    var type: FightType = FightType.ATTACK
)