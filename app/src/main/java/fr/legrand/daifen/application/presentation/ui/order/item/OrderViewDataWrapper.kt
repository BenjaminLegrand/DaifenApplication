package fr.legrand.daifen.application.presentation.ui.order.item

import android.content.Context
import fr.legrand.daifen.application.R
import fr.legrand.daifen.application.data.entity.model.Orders

private const val LINE_SEPARATOR = "\n"

data class OrdersViewDataWrapper(
    private val orders: Orders,
    private val currentRound: Boolean
) {


    private val buildingList =
        orders.buildings.map { BuildingViewDataWrapper(it) }

    private val troopList =
        orders.troops.map { TroopViewDataWrapper(it) }

    private val specialTroopList =
        orders.specialTroops.groupingBy { it }.eachCount()
            .map { SpecialTroopViewDataWrapper(it.key, it.value) }

    private val giftList =
        orders.gifts.map { GiftViewDataWrapper(it) }

    private val attackList =
        orders.attacks.map { AttackViewDataWrapper(it) }

    private val supportList =
        orders.supports.map { SupportViewDataWrapper(it) }

    private val knowledge = orders.knowledge?.let { KnowledgeViewDataWrapper(it) }

    fun getRoundText(context: Context): String =
        context.getString(R.string.orders_round_format, orders.round)

    fun getRound() = orders.round

    fun getKnowledgeText(context: Context): String = knowledge?.let {
        if (currentRound) {
            context.getString(
                R.string.orders_knowledge_format_current,
                it.getKnowledgeTypeText(context)
            )
        } else {
            context.getString(R.string.orders_knowledge_format, it.getKnowledgeTypeText(context))
        }
    } ?: context.getString(R.string.no_knowledge)

    fun getBuildingsText(context: Context): String = if (buildingList.isEmpty()) {
        context.getString(R.string.no_building)
    } else {
        buildingList.joinToString(separator = LINE_SEPARATOR) {
            it.getBuildingText(
                context,
                currentRound
            )
        }
    }

    fun getTroopsText(context: Context): String = if (troopList.isEmpty()) {
        context.getString(R.string.no_troops)
    } else {
        troopList.joinToString(separator = LINE_SEPARATOR) {
            it.getTroopText(
                context,
                currentRound
            )
        }
    }

    fun getGiftsText(context: Context): String = if (giftList.isEmpty()) {
        context.getString(R.string.no_gifts)
    } else {
        giftList.joinToString(separator = LINE_SEPARATOR) { it.getGiftText(context, currentRound) }
    }

    fun getSpecialTroopsText(context: Context): String = if (specialTroopList.isEmpty()) {
        context.getString(R.string.no_special_troops)
    } else {
        specialTroopList.joinToString(separator = LINE_SEPARATOR) {
            it.getSpecialTroopText(
                context,
                currentRound
            )
        }
    }

    fun getAttacksText(context: Context): String = if (attackList.isEmpty()) {
        context.getString(R.string.no_attacks)
    } else {
        attackList.joinToString(separator = LINE_SEPARATOR) {
            it.getAttackText(
                context,
                currentRound
            )
        }
    }

    fun getSupportsText(context: Context): String = if (supportList.isEmpty()) {
        context.getString(R.string.no_supports)
    } else {
        supportList.joinToString(separator = LINE_SEPARATOR) {
            it.getSupportText(
                context,
                currentRound
            )
        }
    }
}