package fr.legrand.daifen.application.data.entity.model

data class Fight(
    val attackers: List<Player>,
    val defenders : List<Player>,
    val attackersTroops : List<Troop>,
    val defendersTroops : List<Troop>,
    val attackersLosses : List<Troop>,
    val defendersLosses : List<Troop>,
    val destroyedBuildings : List<Building>
)