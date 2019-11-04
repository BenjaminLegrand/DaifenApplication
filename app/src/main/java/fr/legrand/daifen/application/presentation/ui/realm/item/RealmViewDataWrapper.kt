package fr.legrand.daifen.application.presentation.ui.realm.item

import android.content.Context
import fr.legrand.daifen.application.R
import fr.legrand.daifen.application.data.entity.model.Realm
import fr.legrand.daifen.application.presentation.ui.order.item.BuildingViewDataWrapper
import fr.legrand.daifen.application.presentation.ui.order.item.KnowledgeViewDataWrapper
import fr.legrand.daifen.application.presentation.ui.order.item.TroopViewDataWrapper

private const val SHARE_DATA_SEPARATOR = "\n\n"
private const val SHARE_DATA_ITEM_SEPARATOR = "\n\t\t"
private const val SHARE_DATA_SPACE = "  "
private const val SHARE_DATA_CLAN_SEPARATOR = " - "
private const val MARKDOWN_BOLD = "**"

data class RealmViewDataWrapper(
    private val realm: Realm
) {

    val buildings = realm.buildings.map { BuildingViewDataWrapper(it) }
    val troops = realm.troops.map { TroopViewDataWrapper(it) }
    val knowledges = realm.knowledges.map { KnowledgeViewDataWrapper(it) }
    private val discoveredPlayers = realm.discoveredPlayers.map { PlayerViewDataWrapper(it) }

    private val goldPerRound =
        buildings.sumBy { it.getGoldIncome() } + troops.sumBy { it.getGold() }
    private val intellectPerRound =
        buildings.sumBy { it.getIntellectIncome() } + troops.sumBy { it.getIntellect() }

    fun getPlayerName() = realm.playerName

    fun getGroupedDiscoveredPlayers(context: Context) =
        discoveredPlayers.groupBy { it.getClan(context) }.toSortedMap()

    fun getRankText(context: Context): String = context.getString(
        R.string.realm_rank_format,
        realm.rank
    )

    fun getPointsText(context: Context): String = context.getString(
        R.string.realm_points_format,
        realm.points
    )

    fun getPlayerImageUrl(): String = realm.playerImage

    fun getGold(): String = realm.gold.toString()

    fun getGoldPerRound(context: Context): String = if (goldPerRound < 0) {
        context.getString(R.string.per_round_negative_format, goldPerRound)
    } else {
        context.getString(R.string.per_round_positive_format, goldPerRound)
    }

    fun getIntellect(): String = realm.intellect.toString()

    fun getIntellectPerRound(context: Context): String = if (intellectPerRound < 0) {
        context.getString(R.string.per_round_negative_format, intellectPerRound)
    } else {
        context.getString(R.string.per_round_positive_format, intellectPerRound)
    }


    fun getShareData(context: Context): String =
        context.getString(
            R.string.realm_share_title_stats_format,
            context.getString(R.string.troops_title),
            getTroopsStatsForShare(context)
        ).toMarkdownBold() + SHARE_DATA_ITEM_SEPARATOR +
                troops.joinToString(SHARE_DATA_ITEM_SEPARATOR) { it.getTroopTypeCountText(context) } + SHARE_DATA_SEPARATOR +
                context.getString(R.string.realm_discovered_players_title).toMarkdownBold() + SHARE_DATA_ITEM_SEPARATOR +
                discoveredPlayers.joinToString(SHARE_DATA_ITEM_SEPARATOR) {
                    it.getName() + SHARE_DATA_SPACE + it.getRaceSecondaryText(
                        context
                    ) + SHARE_DATA_CLAN_SEPARATOR + it.getClan(context)
                }

    private fun getTroopsAttackStat(context: Context): String {
        val minTroopAttack = troops.sumBy { it.getAttack() }
        val maxTroopAttack = troops.sumBy { MAX_DICE_VALUE * it.getAttack() }
        return context.getString(R.string.realm_min_max_text_format, minTroopAttack, maxTroopAttack)
    }

    private fun getTroopsHpStat(context: Context): String {
        val minTroopHp = troops.sumBy { it.getDefense() + it.getResistance() }
        val maxTroopHp = troops.sumBy { MAX_DICE_VALUE * it.getDefense() + it.getResistance() }
        return context.getString(R.string.realm_min_max_text_format, minTroopHp, maxTroopHp)
    }

    private fun getTroopsStatsForShare(context: Context): String = context.getString(
        R.string.realm_share_troops_stats_format,
        getTroopsAttackStat(context), getTroopsHpStat(context)
    )

    companion object {
        const val MAX_DICE_VALUE = 3
    }

    private fun String.toMarkdownBold(): String {
        return MARKDOWN_BOLD + this + MARKDOWN_BOLD
    }
}

