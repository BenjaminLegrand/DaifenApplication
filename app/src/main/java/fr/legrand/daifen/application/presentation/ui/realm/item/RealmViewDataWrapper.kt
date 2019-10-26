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
    val discoveredPlayers = realm.discoveredPlayers.map { PlayerViewDataWrapper(it) }

    fun getPlayerName() = realm.playerName

    fun getRankText(context: Context): String = context.getString(
        R.string.realm_rank_format,
        realm.rank
    )

    fun getPointsText(context: Context): String = context.getString(
        R.string.realm_points_format,
        realm.points
    )

    fun getPlayerImageUrl(): String = realm.playerImage
}