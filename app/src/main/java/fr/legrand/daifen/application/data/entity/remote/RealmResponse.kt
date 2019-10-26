package fr.legrand.daifen.application.data.entity.remote

import pl.droidsonroids.jspoon.annotation.Selector

data class RealmResponse(
    @Selector("#nom")
    var playerName: String = "",
    @Selector(".portrait", attr = "src")
    var playerImage: String = "",
    @Selector("#contenu p > b:nth-of-type(1)")
    var rank: String = "",
    @Selector("#contenu p > b:nth-of-type(2)")
    var points: String = "",
    @Selector("#contenu > table:nth-of-type(1) tbody .even td:nth-of-type(1)")
    var gold: String = "",
    @Selector("#contenu > table:nth-of-type(1) tbody .odd td:nth-of-type(1)")
    var intellect: String = "",
    @Selector("#contenu > table:nth-of-type(2) .even, #contenu > table:nth-of-type(2) .odd")
    var buildings: List<RealmBuildingRemoteEntity> = emptyList(),
    @Selector("#contenu > table:nth-of-type(3) .even, #contenu > table:nth-of-type(3) .odd")
    var troops: List<RealmTroopRemoteEntity> = emptyList(),
    @Selector("#contenu > table:nth-of-type(4) .even, #contenu > table:nth-of-type(4) .odd")
    var knowledges: List<RealmKnowledgeRemoteEntity> = emptyList(),
    @Selector("#contenu > table:nth-of-type(5) .even, #contenu > table:nth-of-type(5) .odd")
    var discoveredPlayers: List<RealmDiscoveredPlayerRemoteEntity> = emptyList()
)
