package fr.legrand.daifen.application.data.entity.remote

import fr.legrand.daifen.application.data.values.FightType
import pl.droidsonroids.jspoon.annotation.Selector

data class FightListItemRemoteEntity(
    @Selector("td:nth-of-type(1)")
    var round: Int = 0,
    @Selector("td:nth-of-type(2) a")
    var target: String = "",
    @Selector("td:nth-of-type(3) a", attr = "href")
    var url: String = "",
    var type: FightType = FightType.ATTACK,
    var targetId: Int = 0
)