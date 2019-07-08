package fr.legrand.daifen.application.data.entity.remote

import pl.droidsonroids.jspoon.annotation.Selector

data class PigeonRemoteEntity(
    @Selector("td:nth-child(2) a", attr = "href")
    var id: String = "",
    @Selector("td:nth-child(1) a")
    var emitter: String = "",
    @Selector("td:nth-child(2) a")
    var subject: String = "",
    @Selector("td:nth-child(3)")
    var date: String = "",
    var content: String = "",
    var history: List<String> = emptyList()
)