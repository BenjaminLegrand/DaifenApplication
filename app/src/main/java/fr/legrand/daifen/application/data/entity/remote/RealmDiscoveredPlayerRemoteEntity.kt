package fr.legrand.daifen.application.data.entity.remote

import pl.droidsonroids.jspoon.annotation.Selector

data class RealmDiscoveredPlayerRemoteEntity(
    @Selector("td:nth-of-type(1) a")
    var name: String = "",
    @Selector("td:nth-of-type(2)")
    var race: String = "",
    @Selector("td:nth-of-type(4)")
    var clan: String = ""
)
