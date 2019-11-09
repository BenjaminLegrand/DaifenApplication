package fr.legrand.daifen.application.presentation.utils

import fr.legrand.daifen.application.presentation.ui.order.item.TroopViewDataWrapper

object TroopUtils {

    private const val MAX_DICE_VALUE = 3

    fun getMinAttack(troops: List<TroopViewDataWrapper>): Int {
        return troops.sumBy { it.getAttack() }
    }

    fun getMaxAttack(troops: List<TroopViewDataWrapper>): Int {
        return troops.sumBy { MAX_DICE_VALUE * it.getAttack() }
    }

    fun getMinHp(troops: List<TroopViewDataWrapper>): Int {
        return troops.sumBy { it.getDefense() + it.getResistance() }
    }

    fun getMaxHp(troops: List<TroopViewDataWrapper>): Int {
        return troops.sumBy { MAX_DICE_VALUE * it.getDefense() + it.getResistance() }
    }
}