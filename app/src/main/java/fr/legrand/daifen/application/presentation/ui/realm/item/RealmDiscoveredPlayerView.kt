package fr.legrand.daifen.application.presentation.ui.realm.item

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import fr.legrand.daifen.application.R
import kotlinx.android.synthetic.main.view_realm_discovered_player_item.view.*

class RealmDiscoveredPlayerView(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    ConstraintLayout(context, attrs, defStyleAttr) {

    //Used for auto inflating in XML
    constructor(context: Context?, attrs: AttributeSet? = null) : this(context, attrs, 0)

    constructor(context: Context?) : this(context, null)

    init {
        inflate(getContext(), R.layout.view_realm_discovered_player_item, this)
    }

    fun bindItem(item: RealmPlayerViewDataWrapper) {
        realm_discovered_players_item_name.text = item.getName()
        realm_discovered_players_item_race.text = item.getRaceSecondaryText(context)
    }
}