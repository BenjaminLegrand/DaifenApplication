package fr.legrand.daifen.application.presentation.ui.realm.item

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import fr.legrand.daifen.application.R
import fr.legrand.daifen.application.presentation.ui.order.item.TroopViewDataWrapper
import fr.legrand.daifen.application.presentation.utils.TroopUtils
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

        val minAttack = TroopUtils.getMinAttack(items)
        val maxAttack = TroopUtils.getMaxAttack(items)
        realm_troop_item_attack.text =
            context.getString(
                R.string.realm_min_max_text_format,
                minAttack,
                maxAttack,
                (minAttack + maxAttack) / 2
            )

        val minHp = TroopUtils.getMinHp(items)
        val maxHp = TroopUtils.getMaxHp(items)
        realm_troop_item_hp.text =
            context.getString(R.string.realm_min_max_text_format, minHp, maxHp, (minHp + maxHp) / 2)
    }
}