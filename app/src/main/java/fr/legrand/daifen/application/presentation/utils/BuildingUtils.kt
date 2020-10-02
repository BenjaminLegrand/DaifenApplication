package fr.legrand.daifen.application.presentation.utils

import fr.legrand.daifen.application.presentation.ui.order.item.BuildingViewDataWrapper

object BuildingUtils {

    private const val MAX_DICE_VALUE = 3

    fun getMinAttack(buildings: List<BuildingViewDataWrapper>): Int {
        return buildings.sumBy { it.getAttack() }
    }

    fun getMaxAttack(buildings: List<BuildingViewDataWrapper>): Int {
        return buildings.sumBy { MAX_DICE_VALUE * it.getAttack() }
    }

    fun getMinResistance(buildings: List<BuildingViewDataWrapper>): Int {
        return buildings.sumBy { it.getResistance() }
    }

    fun getMaxResistance(buildings: List<BuildingViewDataWrapper>): Int {
        return buildings.sumBy { MAX_DICE_VALUE * it.getResistance() }
    }
}