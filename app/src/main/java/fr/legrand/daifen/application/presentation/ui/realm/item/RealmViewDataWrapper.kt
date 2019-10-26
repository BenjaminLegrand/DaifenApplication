package fr.legrand.daifen.application.presentation.ui.realm.item

import android.content.Context
import fr.legrand.daifen.application.R
import fr.legrand.daifen.application.data.entity.model.Realm
import fr.legrand.daifen.application.presentation.ui.order.item.BuildingViewDataWrapper
import fr.legrand.daifen.application.presentation.ui.order.item.KnowledgeViewDataWrapper
import fr.legrand.daifen.application.presentation.ui.order.item.TroopViewDataWrapper

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
}