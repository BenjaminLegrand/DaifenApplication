package fr.legrand.daifen.application.presentation.ui.order.item

import android.content.Context
import fr.legrand.daifen.application.R
import fr.legrand.daifen.application.data.entity.model.SpecialTroop
import fr.legrand.daifen.application.data.values.SpecialTroopActionType

data class SpecialTroopViewDataWrapper(
    private val specialTroop: SpecialTroop
) {
    private val troop = TroopViewDataWrapper(specialTroop.troopType, 1)

    fun getSpecialTroopText(context: Context): String =
        when (specialTroop.specialTroopAction) {
            SpecialTroopActionType.EXPLORE -> context.getString(
                R.string.special_troop_explore_text_format,
                troop.getTroopTypeText(context)
            )
            SpecialTroopActionType.SPY -> context.getString(
                R.string.special_troop_spy_text_format,
                troop.getTroopTypeText(context),
                specialTroop.target
            )
            SpecialTroopActionType.COUNTER_SPY -> context.getString(
                R.string.special_troop_counter_spy_text_format,
                troop.getTroopTypeText(context)
            )
            SpecialTroopActionType.STEAL -> context.getString(
                R.string.special_troop_steal_text_format,
                troop.getTroopTypeText(context),
                specialTroop.target
            )
            SpecialTroopActionType.SABOTAGE -> context.getString(
                R.string.special_troop_sabotage_text_format,
                troop.getTroopTypeText(context),
                specialTroop.target
            )
            SpecialTroopActionType.MURDER -> context.getString(
                R.string.special_troop_murder_text_format,
                troop.getTroopTypeText(context),
                specialTroop.target
            )
            SpecialTroopActionType.SHOW -> context.getString(
                R.string.special_troop_show_text_format,
                troop.getTroopTypeText(context),
                specialTroop.showTarget,
                specialTroop.target
            )
            SpecialTroopActionType.GIVE -> context.getString(
                R.string.special_troop_give_text_format,
                troop.getTroopTypeText(context),
                specialTroop.target
            )
        }
}