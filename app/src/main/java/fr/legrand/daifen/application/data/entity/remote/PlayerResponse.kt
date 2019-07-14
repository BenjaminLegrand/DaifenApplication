package fr.legrand.daifen.application.data.entity.remote

import pl.droidsonroids.jspoon.annotation.Selector

data class PlayerResponse(
    @Selector("#illus", attr = "src")
    var image: String = ""
)
