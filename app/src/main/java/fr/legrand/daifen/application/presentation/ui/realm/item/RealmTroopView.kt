package fr.legrand.daifen.application.presentation.ui.realm.item

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import fr.legrand.daifen.application.R
import fr.legrand.daifen.application.presentation.ui.order.item.TroopViewDataWrapper
import kotlinx.android.synthetic.main.view_realm_troop_item.view.*

class RealmTroopView(context: Context?, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    ConstraintLayout(context, attrs, defStyleAttr) {

    //Used for auto inflating in XML
    constructor(context: Context?, attrs: AttributeSet? = null) : this(context, attrs, 0)

    constructor(context: Context?) : this(context, null)

    init {
        inflate(getContext(), R.layout.view_realm_troop_item, this)
    }

    fun bindItems(items: List<TroopViewDataWrapper>) {
        realm_troop_item_type.text =
            items.joinToString {
                it.getTroopTypeCountText(context)
            }

        val totalAttack = items.sumBy { it.getAttack() }
        realm_troop_item_attack.text = if (totalAttack < 0) {
            context.getString(R.string.realm_negative_value_format, totalAttack)
        } else {
            context.getString(R.string.realm_positive_value_format, totalAttack)
        }

        val totalDefense = items.sumBy { it.getDefense() }
        realm_troop_item_defense.text = if (totalDefense < 0) {
            context.getString(R.string.realm_negative_value_format, totalDefense)
        } else {
            context.getString(R.string.realm_positive_value_format, totalDefense)
        }

        val totalResistance = items.sumBy { it.getResistance() }
        realm_troop_item_resistance.text = if (totalResistance < 0) {
            context.getString(R.string.realm_negative_value_format, totalResistance)
        } else {
            context.getString(R.string.realm_positive_value_format, totalResistance)
        }

        val totalGold = items.sumBy { it.getGold() }
        realm_troop_item_gold.text = if (totalGold < 0) {
            context.getString(R.string.realm_negative_value_format, totalGold)
        } else {
            context.getString(R.string.realm_positive_value_format, totalGold)
        }

        val totalIntellect = items.sumBy { it.getIntellect() }
        realm_troop_item_intellect.text = if (totalIntellect < 0) {
            context.getString(R.string.realm_negative_value_format, totalIntellect)
        } else {
            context.getString(R.string.realm_positive_value_format, totalIntellect)
        }
    }
}