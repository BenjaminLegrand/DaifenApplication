package fr.legrand.daifen.application.presentation.ui.fight.detail.item

import android.content.Context
import fr.legrand.daifen.application.R
import fr.legrand.daifen.application.data.entity.model.FightDetail
import fr.legrand.daifen.application.data.values.FightType
import fr.legrand.daifen.application.presentation.ui.order.item.TroopViewDataWrapper
import fr.legrand.daifen.application.presentation.ui.player.item.PlayerViewDataWrapper
import fr.legrand.daifen.application.presentation.utils.TroopUtils

data class FightDetailViewDataWrapper(
    private val fightDetail: FightDetail
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

    val attackers = fightDetail.attackers.map { PlayerViewDataWrapper(it) }
    val defenders = fightDetail.defenders.map { PlayerViewDataWrapper(it) }
    val attackersTroops = fightDetail.attackersTroops.map { TroopViewDataWrapper(it) }
    val defendersTroops = fightDetail.defendersTroops.map { TroopViewDataWrapper(it) }
    val attackersLosses = fightDetail.attackersLosses.map { TroopViewDataWrapper(it) }
    val defendersLosses = fightDetail.defendersLosses.map { TroopViewDataWrapper(it) }

    val attackersRemaining = fightDetail.attackersTroops.mapNotNull { troop ->
        fightDetail.attackersLosses.find { it.troopType == troop.troopType }?.let { loss ->
            val remaining = troop.count - loss.count
            if (remaining == 0) {
                return@mapNotNull null
            } else {
                TroopViewDataWrapper(troop.copy(count = remaining))
            }
        } ?: TroopViewDataWrapper(troop)
    }

    val defendersRemaining = fightDetail.defendersTroops.mapNotNull { troop ->
        fightDetail.defendersLosses.find { it.troopType == troop.troopType }?.let { loss ->
            val remaining = troop.count - loss.count
            if (remaining == 0) {
                return@mapNotNull null
            } else {
                TroopViewDataWrapper(troop.copy(count = remaining))
            }
        } ?: TroopViewDataWrapper(troop)
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