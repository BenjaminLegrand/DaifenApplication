package fr.legrand.daifen.application.presentation.ui.order.item

import android.content.Context
import fr.legrand.daifen.application.R
import fr.legrand.daifen.application.data.entity.model.Orders

private val LINE_SEPARATOR = "\n"

data class OrdersViewDataWrapper(
    private val orders: Orders
) {

    private val buildingList =
        orders.buildings.map { BuildingViewDataWrapper(it.buildingType, it.count) }

    private val troopList =
        orders.troops.map { TroopViewDataWrapper(it.troopType, it.count) }

    private val specialTroopList =
        orders.specialTroops.map { SpecialTroopViewDataWrapper(it) }

    private val giftList =
        orders.gifts.map { GiftViewDataWrapper(it) }

    private val attackList =
        orders.attacks.map { AttackViewDataWrapper(it) }

    private val supportList =
        orders.supports.map { SupportViewDataWrapper(it) }

    fun getRoundText(context: Context): String =
        context.getString(R.string.orders_round_format, orders.round)

    fun getRound() = orders.round

    fun getKnowledgeText(context: Context): String = orders.knowledge?.let {
        context.getString(R.string.orders_knowledge_format, it.value)
    } ?: context.getString(R.string.no_knowledge)

    fun getBuildingsText(context: Context) =
        buildingList.joinToString(separator = LINE_SEPARATOR) { it.getBuildingText(context) }

    fun getTroopsText(context: Context) =
        troopList.joinToString(separator = LINE_SEPARATOR) { it.getTroopText(context) }

    fun getGiftsText(context: Context) =
        giftList.joinToString(separator = LINE_SEPARATOR) { it.getGiftText(context) }

    fun getSpecialTroopsText(context: Context) =
        specialTroopList.joinToString(separator = LINE_SEPARATOR) { it.getSpecialTroopText(context) }

    fun getAttacksText(context: Context) =
        attackList.joinToString(separator = LINE_SEPARATOR) { it.getAttackText(context) }

    fun getSupportsText(context: Context) =
        supportList.joinToString(separator = LINE_SEPARATOR) { it.getSupportText(context) }
}