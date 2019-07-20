package fr.legrand.daifen.application.presentation.ui.order.item

import android.content.Context
import fr.legrand.daifen.application.R
import fr.legrand.daifen.application.data.entity.model.Support

data class SupportViewDataWrapper(
    private val support: Support
) {
    val troops = support.troops.map { TroopViewDataWrapper(it.key, it.value) }

    fun getSupportText(context: Context, currentRound: Boolean): String =
        if (currentRound) {
            context.getString(
                R.string.support_text_format_current,
                support.target,
                troops.joinToString { it.getTroopTypeCountText(context) })
        } else {
            context.getString(
                R.string.support_text_format,
                support.target,
                troops.joinToString { it.getTroopTypeCountText(context) })
        }
}