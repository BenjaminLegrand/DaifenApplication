package fr.legrand.daifen.application.presentation.ui.realm.item

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import fr.legrand.daifen.application.R
import fr.legrand.daifen.application.presentation.ui.order.item.BuildingViewDataWrapper
import kotlinx.android.synthetic.main.view_realm_building_item.view.*

private const val BUILDING_SEPARATOR = " / "

class RealmBuildingView(context: Context?, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    ConstraintLayout(context, attrs, defStyleAttr) {

    //Used for auto inflating in XML
    constructor(context: Context?, attrs: AttributeSet? = null) : this(context, attrs, 0)

    constructor(context: Context?) : this(context, null)

    init {
        inflate(getContext(), R.layout.view_realm_building_item, this)
    }

    fun bindItems(items: List<BuildingViewDataWrapper>) {
        realm_building_item_type.text =
            items.joinToString {
                it.getBuildingTypeCountText(context)
            }

        val totalAttack = items.sumBy { it.getAttack() }
        realm_building_item_attack.text = if (totalAttack < 0) {
            context.getString(R.string.realm_negative_value_format, totalAttack)
        } else {
            context.getString(R.string.realm_positive_value_format, totalAttack)
        }

        val totalResistance = items.sumBy { it.getResistance() }
        realm_building_item_resistance.text = if (totalResistance < 0) {
            context.getString(R.string.realm_negative_value_format, totalResistance)
        } else {
            context.getString(R.string.realm_positive_value_format, totalResistance)
        }

        val totalGold = items.sumBy { it.getGoldIncome() }
        realm_building_item_gold.text = if (totalGold < 0) {
            context.getString(R.string.realm_negative_value_format, totalGold)
        } else {
            context.getString(R.string.realm_positive_value_format, totalGold)
        }

        val totalIntellect = items.sumBy { it.getIntellectIncome() }
        realm_building_item_intellect.text = if (totalIntellect < 0) {
            context.getString(R.string.realm_negative_value_format, totalIntellect)
        } else {
            context.getString(R.string.realm_positive_value_format, totalIntellect)
        }
    }
}