package fr.legrand.daifen.application.presentation.ui.order.item

import android.content.Context
import fr.legrand.daifen.application.R
import fr.legrand.daifen.application.data.entity.model.Attack

data class AttackViewDataWrapper(
    private val attack: Attack
) {
    val troops = attack.troops.map { TroopViewDataWrapper(it.key, it.value) }

    fun getAttackText(context: Context): String =
        context.getString(
            R.string.attack_text_format,
            attack.target,
            troops.joinToString { it.getTroopTypeCountText(context) })
}