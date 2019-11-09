package fr.legrand.daifen.application.data.entity.model

import fr.legrand.daifen.application.data.values.FightType

data class Fight(
    val id: Int,
    val type : FightType,
    val attackers: List<Player>,
    val defenders: List<Player>,
    val attackersTroops: List<Troop>,
    val defendersTroops: List<Troop>,
    val attackersLosses: List<Troop>,
    val defendersLosses: List<Troop>,
    val destroyedBuildings: List<Building>
)