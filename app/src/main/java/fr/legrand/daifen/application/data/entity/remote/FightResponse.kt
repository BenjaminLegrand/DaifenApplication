package fr.legrand.daifen.application.data.entity.remote

import pl.droidsonroids.jspoon.annotation.Selector

data class FightResponse(
    @Selector("a")
    var id: Int = 0
)