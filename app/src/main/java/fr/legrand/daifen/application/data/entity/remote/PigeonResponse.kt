package fr.legrand.daifen.application.data.entity.remote

import pl.droidsonroids.jspoon.annotation.Selector

data class PigeonResponse(
    @Selector("#main > p")
    var pigeonConversationData: List<String> = emptyList(),
    @Selector("#main .fiche")
    var emitter: String = "",
    @Selector("#main > p:nth-of-type(3)")
    var receivers: String = "",
    @Selector("#main h2")
    var subject: String = "",
    @Selector("#main :nth-child(5) a", attr = "href")
    var emitterId: String = ""
)
