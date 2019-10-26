package fr.legrand.daifen.application.presentation.ui.order.item

import android.content.Context
import fr.legrand.daifen.application.R
import fr.legrand.daifen.application.data.entity.model.Gift

data class GiftViewDataWrapper(
    private val gift: Gift
) {

    private val troop = TroopViewDataWrapper(gift.troopType, gift.count)

    fun getGiftText(context: Context, currentRound: Boolean): String = if (currentRound) {
        context.getString(
            R.string.gift_text_format_current,
            troop.getTroopTypeCountText(context),
            gift.target
        )
    } else {
        context.getString(
            R.string.gift_text_format,
            troop.getTroopTypeCountText(context),
            gift.target
        )
    }

}