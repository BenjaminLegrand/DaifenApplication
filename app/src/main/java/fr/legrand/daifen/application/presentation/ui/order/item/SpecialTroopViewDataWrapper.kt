package fr.legrand.daifen.application.presentation.ui.order.item

import android.content.Context
import fr.legrand.daifen.application.R
import fr.legrand.daifen.application.data.entity.model.SpecialTroop
import fr.legrand.daifen.application.data.values.SpecialTroopActionType

data class SpecialTroopViewDataWrapper(
    private val specialTroop: SpecialTroop,
    private val count: Int
) {
    //We put 2 because sentences are plural in resources
    private val troop = TroopViewDataWrapper(specialTroop.troopType, count)

    fun getSpecialTroopText(context: Context, currentRound: Boolean): String =
        if (currentRound) {
            when (specialTroop.specialTroopAction) {
                SpecialTroopActionType.EXPLORE -> context.resources.getQuantityString(
                    R.plurals.special_troop_explore_text_format_current,
                    count, count, troop.getTroopTypeText(context)
                )
                SpecialTroopActionType.SPY -> context.resources.getQuantityString(
                    R.plurals.special_troop_spy_text_format_current,
                    count, count, troop.getTroopTypeText(context),
                    specialTroop.target
                )
                SpecialTroopActionType.COUNTER_SPY -> context.resources.getQuantityString(
                    R.plurals.special_troop_counter_spy_text_format_current,
                    count, count, troop.getTroopTypeText(context)
                )
                SpecialTroopActionType.STEAL -> context.resources.getQuantityString(
                    R.plurals.special_troop_steal_text_format_current,
                    count, count, troop.getTroopTypeText(context),
                    specialTroop.target
                )
                SpecialTroopActionType.SABOTAGE -> context.resources.getQuantityString(
                    R.plurals.special_troop_sabotage_text_format_current,
                    count, count, troop.getTroopTypeText(context),
                    specialTroop.target
                )
                SpecialTroopActionType.MURDER -> context.resources.getQuantityString(
                    R.plurals.special_troop_murder_text_format_current,
                    count, count, troop.getTroopTypeText(context),
                    specialTroop.target
                )
                SpecialTroopActionType.SHOW -> context.resources.getQuantityString(
                    R.plurals.special_troop_show_text_format_current,
                    count, count, troop.getTroopTypeText(context),
                    specialTroop.showTarget,
                    specialTroop.target
                )
                SpecialTroopActionType.GIVE -> context.resources.getQuantityString(
                    R.plurals.special_troop_give_text_format_current,
                    count, count, troop.getTroopTypeText(context),
                    specialTroop.target
                )
            }
        } else {
            when (specialTroop.specialTroopAction) {
                SpecialTroopActionType.EXPLORE -> context.resources.getQuantityString(
                    R.plurals.special_troop_explore_text_format,
                    count, count, troop.getTroopTypeText(context)
                )
                SpecialTroopActionType.SPY -> context.resources.getQuantityString(
                    R.plurals.special_troop_spy_text_format,
                    count, count, troop.getTroopTypeText(context),
                    specialTroop.target
                )
                SpecialTroopActionType.COUNTER_SPY -> context.resources.getQuantityString(
                    R.plurals.special_troop_counter_spy_text_format,
                    count, count, troop.getTroopTypeText(context)
                )
                SpecialTroopActionType.STEAL -> context.resources.getQuantityString(
                    R.plurals.special_troop_steal_text_format,
                    count, count, troop.getTroopTypeText(context),
                    specialTroop.target
                )
                SpecialTroopActionType.SABOTAGE -> context.resources.getQuantityString(
                    R.plurals.special_troop_sabotage_text_format,
                    count, count, troop.getTroopTypeText(context),
                    specialTroop.target
                )
                SpecialTroopActionType.MURDER -> context.resources.getQuantityString(
                    R.plurals.special_troop_murder_text_format,
                    count, count, troop.getTroopTypeText(context),
                    specialTroop.target
                )
                SpecialTroopActionType.SHOW -> context.resources.getQuantityString(
                    R.plurals.special_troop_show_text_format,
                    count, count, troop.getTroopTypeText(context),
                    specialTroop.showTarget,
                    specialTroop.target
                )
                SpecialTroopActionType.GIVE -> context.resources.getQuantityString(
                    R.plurals.special_troop_give_text_format,
                    count, count, troop.getTroopTypeText(context),
                    specialTroop.target
                )
            }
        }

}