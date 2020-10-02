package fr.legrand.daifen.application.data.entity.remote

import pl.droidsonroids.jspoon.annotation.Selector

data class PigeonRemoteEntity(
    @Selector("td:nth-child(2) a", attr = "href")
    var id: String = "",
    @Selector("td:nth-child(1) a")
    var emitter: String = "",
    @Selector("td:nth-child(2) a")
    var subject: String = "",
    @Selector("td:nth-child(2) img", attr = "alt")
    var unread: String? = null,
    @Selector("td:nth-child(3)")
    var date: String = "",
    var emitterPlayer: PlayerRemoteEntity = PlayerRemoteEntity(),
    var emitterId: Int = 0,
    var content: String = "",
    var receivers: List<String> = emptyList(),
    var history: List<String> = emptyList()
)