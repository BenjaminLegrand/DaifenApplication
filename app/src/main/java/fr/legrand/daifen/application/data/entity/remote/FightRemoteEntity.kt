package fr.legrand.daifen.application.data.entity.remote

data class FightRemoteEntity(
    val attackers: List<PlayerRemoteEntity> = emptyList(),
    val defenders: List<PlayerRemoteEntity> = emptyList(),
    val attackersTroops: List<TroopRemoteEntity> = emptyList(),
    val defendersTroops: List<TroopRemoteEntity> = emptyList(),
    val attackersLosses: List<TroopRemoteEntity> = emptyList(),
    val defendersLosses: List<TroopRemoteEntity> = emptyList(),
    val destroyedBuildings: List<BuildingRemoteEntity> = emptyList()
)