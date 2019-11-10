package fr.legrand.daifen.application.presentation.ui.fight.list.item

import android.content.Context
import fr.legrand.daifen.application.R
import fr.legrand.daifen.application.data.entity.model.Fight
import fr.legrand.daifen.application.data.values.FightType
import fr.legrand.daifen.application.presentation.ui.order.item.TroopViewDataWrapper
import fr.legrand.daifen.application.presentation.ui.player.item.PlayerViewDataWrapper
import fr.legrand.daifen.application.presentation.utils.TroopUtils

data class FightViewDataWrapper(
    private val fight: Fight
) {

    private val attackWinnerTexts = arrayOf(
        R.string.fight_attackers_winner_1,
        R.string.fight_attackers_winner_2
    )
    private val defenseWinnerTexts = arrayOf(
        R.string.fight_defenders_winner_1,
        R.string.fight_defenders_winner_2
    )
    private val noWinnerTexts = arrayOf(
        R.string.fight_no_winner_1,
        R.string.fight_no_winner_2,
        R.string.fight_no_winner_3
    )

    val attackers = fight.attackers.map { PlayerViewDataWrapper(it) }
    val defenders = fight.defenders.map { PlayerViewDataWrapper(it) }
    val attackersTroops = fight.attackersTroops.map { TroopViewDataWrapper(it) }
    val defendersTroops = fight.defendersTroops.map { TroopViewDataWrapper(it) }
    val attackersLosses = fight.attackersLosses.map { TroopViewDataWrapper(it) }
    val defendersLosses = fight.defendersLosses.map { TroopViewDataWrapper(it) }

    val attackersRemaining = fight.attackersTroops.mapNotNull { troop ->
        fight.attackersLosses.find { it.troopType == troop.troopType }?.let { loss ->
            val remaining = troop.count - loss.count
            if (remaining == 0) {
                return@mapNotNull null
            } else {
                TroopViewDataWrapper(troop.copy(count = remaining))
            }
        } ?: TroopViewDataWrapper(troop)
    }

    val defendersRemaining = fight.defendersTroops.mapNotNull { troop ->
        fight.defendersLosses.find { it.troopType == troop.troopType }?.let { loss ->
            val remaining = troop.count - loss.count
            if (remaining == 0) {
                return@mapNotNull null
            } else {
                TroopViewDataWrapper(troop.copy(count = remaining))
            }
        } ?: TroopViewDataWrapper(troop)
    }

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

    fun getWinnerText(context: Context): String = when {
        attackersRemaining.isEmpty() -> context.getString(defenseWinnerTexts.random())
        defendersRemaining.isEmpty() -> context.getString(attackWinnerTexts.random())
        else -> context.getString(noWinnerTexts.random())
    }

    fun getAttackersTroopsStats(context: Context): String {
        val minAttack = TroopUtils.getMinAttack(attackersTroops)
        val maxAttack = TroopUtils.getMaxAttack(attackersTroops)
        val minHp = TroopUtils.getMinHp(attackersTroops)
        val maxHp = TroopUtils.getMaxHp(attackersTroops)

        return context.getString(
            R.string.fight_stats_text_format,
            context.getString(
                R.string.fight_attack_text_format,
                minAttack,
                maxAttack,
                (minAttack + maxAttack) / 2
            ),
            context.getString(R.string.fight_hp_text_format, minHp, maxHp, (minHp + maxHp) / 2)
        )
    }

    fun getDefendersTroopsStats(context: Context): String {
        val minAttack = TroopUtils.getMinAttack(defendersTroops)
        val maxAttack = TroopUtils.getMaxAttack(defendersTroops)
        val minHp = TroopUtils.getMinHp(defendersTroops)
        val maxHp = TroopUtils.getMaxHp(defendersTroops)

        return context.getString(
            R.string.fight_stats_text_format,
            context.getString(
                R.string.fight_attack_text_format,
                minAttack,
                maxAttack,
                (minAttack + maxAttack) / 2
            ),
            context.getString(R.string.fight_hp_text_format, minHp, maxHp, (minHp + maxHp) / 2)
        )

    }
}