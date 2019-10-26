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

    fun bindItem(item: TroopViewDataWrapper) {
        realm_troop_item_type.text = item.getTroopTypeCountText(context)
    }
}