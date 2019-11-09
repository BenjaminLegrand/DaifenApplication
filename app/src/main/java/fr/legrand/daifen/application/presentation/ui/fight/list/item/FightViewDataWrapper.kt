package fr.legrand.daifen.application.presentation.ui.fight.list.item

import fr.legrand.daifen.application.R
import fr.legrand.daifen.application.data.entity.model.Fight
import fr.legrand.daifen.application.data.values.FightType
import fr.legrand.daifen.application.presentation.ui.order.item.TroopViewDataWrapper
import fr.legrand.daifen.application.presentation.ui.player.item.PlayerViewDataWrapper

data class FightViewDataWrapper(
    private val fight: Fight
) {

    val attackers = fight.attackers.map { PlayerViewDataWrapper(it) }
    val defenders = fight.defenders.map { PlayerViewDataWrapper(it) }
    val attackersTroops = fight.attackersTroops.map { TroopViewDataWrapper(it) }
    val defendersTroops = fight.defendersTroops.map { TroopViewDataWrapper(it) }
    val attackersLosses = fight.attackersLosses.map { TroopViewDataWrapper(it) }
    val defendersLosses = fight.defendersLosses.map { TroopViewDataWrapper(it) }

    fun getId() = fight.id
    fun getAttackersNamesText() = attackers.joinToString { it.getName() }

    fun getDefendersNamesText() = defenders.joinToString { it.getName() }

    fun getAttackTypeIconResource(): Int = when (fight.type) {
        FightType.ATTACK, FightType.DEFENSE -> R.drawable.ic_fight_attack_type
        FightType.SUPPORT -> R.drawable.ic_fight_support_type
    }

    fun isAttack() = fight.type == FightType.ATTACK || fight.type == FightType.DEFENSE

    fun getAttackDirectionIconResource(): Int = when (fight.type) {
        FightType.ATTACK -> R.drawable.ic_fight_attack_to
        else -> R.drawable.ic_fight_attack_from
    }
}