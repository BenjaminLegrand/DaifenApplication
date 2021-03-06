package fr.legrand.daifen.application.presentation.ui.realm.item

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import fr.legrand.daifen.application.R
import fr.legrand.daifen.application.presentation.ui.order.item.BuildingViewDataWrapper
import fr.legrand.daifen.application.presentation.utils.BuildingUtils
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

        val minAttack = BuildingUtils.getMinAttack(items)
        val maxAttack = BuildingUtils.getMaxAttack(items)
        realm_building_item_attack.text =
            context.getString(
                R.string.realm_min_max_text_format,
                minAttack,
                maxAttack,
                (minAttack + maxAttack) / 2
            )

        val minRes = BuildingUtils.getMinResistance(items)
        val maxRes = BuildingUtils.getMaxResistance(items)
        realm_building_item_resistance.text =
            context.getString(
                R.string.realm_min_max_text_format,
                minRes,
                maxRes,
                (minRes + maxRes) / 2
            )
    }
}