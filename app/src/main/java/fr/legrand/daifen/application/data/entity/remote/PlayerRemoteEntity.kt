package fr.legrand.daifen.application.data.entity.remote

import pl.droidsonroids.jspoon.annotation.Selector

data class PlayerRemoteEntity(
    var id : Int = 0,
    @Selector("#illus", attr = "src")
    var image: String = "",
    @Selector("#main > h1:nth-of-type(1)")
    var name: String = ""
)
