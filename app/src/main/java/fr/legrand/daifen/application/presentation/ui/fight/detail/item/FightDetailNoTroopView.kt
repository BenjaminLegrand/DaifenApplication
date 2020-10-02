package fr.legrand.daifen.application.presentation.ui.fight.detail.item

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import fr.legrand.daifen.application.R
import kotlinx.android.synthetic.main.view_fight_detail_troop_item.view.*

class FightDetailNoTroopView(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    ConstraintLayout(context, attrs, defStyleAttr) {

    //Used for auto inflating in XML
    constructor(context: Context?, attrs: AttributeSet? = null) : this(context, attrs, 0)

    constructor(context: Context?) : this(context, null)

    init {
        inflate(getContext(), R.layout.view_fight_detail_troop_item, this)
    }

    fun bindItem(item: String) {
        fight_detail_troop_item_troop_text.typeface = Typeface.DEFAULT_BOLD
        fight_detail_troop_item_troop_text.text = item
    }
}