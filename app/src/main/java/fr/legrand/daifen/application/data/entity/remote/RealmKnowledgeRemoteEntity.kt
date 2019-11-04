package fr.legrand.daifen.application.data.entity.remote

import pl.droidsonroids.jspoon.annotation.Selector

data class RealmKnowledgeRemoteEntity(
    @Selector("td:nth-of-type(1)")
    var knowledgeType: String = "",
    @Selector("td:nth-of-type(2)")
    var round: String = ""
)
