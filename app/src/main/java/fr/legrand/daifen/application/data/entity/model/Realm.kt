package fr.legrand.daifen.application.data.entity.model

data class Realm(
    val playerName: String,
    val playerImage: String,
    val rank: Int,
    val points: Int,
    val gold: Int,
    val intellect: Int,
    val buildings: List<Building>,
    val troops: List<Troop>,
    val knowledges: List<Knowledge>,
    val discoveredRealmPlayers: List<RealmPlayer>
)