package fr.legrand.daifen.application.presentation.ui.realm.item

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import fr.legrand.daifen.application.R
import fr.legrand.daifen.application.presentation.ui.order.item.BuildingViewDataWrapper
import fr.legrand.daifen.application.presentation.ui.realm.item.RealmViewDataWrapper.Companion.MAX_DICE_VALUE
import kotlinx.android.synthetic.main.view_realm_building_item.view.*

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

        val minAttack = items.sumBy { it.getAttack() }
        val maxAttack = items.sumBy { MAX_DICE_VALUE * it.getAttack() }
        realm_building_item_attack.text =
            context.getString(R.string.realm_min_max_text_format, minAttack, maxAttack)

        val minRes = items.sumBy { it.getResistance() }
        val maxRes = items.sumBy { MAX_DICE_VALUE * it.getResistance() }
        realm_building_item_resistance.text =
            context.getString(R.string.realm_min_max_text_format, minRes, maxRes)
    }
}