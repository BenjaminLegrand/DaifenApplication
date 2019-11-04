package fr.legrand.daifen.application.data.entity.remote

import pl.droidsonroids.jspoon.annotation.Selector

data class RealmTroopRemoteEntity(
    @Selector("td:nth-of-type(1) a")
    var troopType: String = "",
    @Selector("td:nth-of-type(2)")
    var count: String = "",
    @Selector("td:nth-of-type(3)")
    var attack: String = "",
    @Selector("td:nth-of-type(4)")
    var defense: String = "",
    @Selector("td:nth-of-type(5)")
    var resistance: String = "",
    @Selector("td:nth-of-type(6)")
    var gold: String = "",
    @Selector("td:nth-of-type(7)")
    var intellect: String = ""
)
