package fr.legrand.daifen.application.data.entity.remote

data class RealmRemoteEntity(
    val playerName: String,
    val playerImage: String,
    val rank: Int,
    val points: Int,
    val gold: Int,
    val intellect: Int,
    val buildings: List<RealmBuildingRemoteEntity>,
    val troops: List<RealmTroopRemoteEntity>,
    val knowledges: List<RealmKnowledgeRemoteEntity>,
    val discoveredPlayers: List<RealmDiscoveredPlayerRemoteEntity>
)
