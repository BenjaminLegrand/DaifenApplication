package fr.legrand.daifen.application.presentation.ui.fight.list.item

import fr.legrand.daifen.application.R
import fr.legrand.daifen.application.data.entity.model.Fight
import fr.legrand.daifen.application.data.values.FightType

data class FightViewDataWrapper(
    private val fight: Fight
) {

    fun getTargetId() = fight.targetId
    fun getRound() = fight.round

    fun getDefenderName() = fight.target

    fun getAttackTypeIconResource(): Int = when (fight.type) {
        FightType.ATTACK, FightType.DEFENSE -> R.drawable.ic_fight_attack_type
        FightType.SUPPORT -> R.drawable.ic_fight_support_type
    }

    fun isAttack() = fight.type == FightType.ATTACK || fight.type == FightType.DEFENSE

    fun getAttackDirectionIconResource(): Int = when (fight.type) {
        FightType.ATTACK -> R.drawable.ic_fight_attack_to
        else -> R.drawable.ic_fight_attack_from
    }
}