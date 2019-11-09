package fr.legrand.daifen.application.presentation.ui.realm.item

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import fr.legrand.daifen.application.R
import kotlinx.android.synthetic.main.view_realm_discovered_player_clan_item.view.*

class RealmDiscoveredPlayerClanView(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    ConstraintLayout(context, attrs, defStyleAttr) {

    //Used for auto inflating in XML
    constructor(context: Context?, attrs: AttributeSet? = null) : this(context, attrs, 0)

    constructor(context: Context?) : this(context, null)

    init {
        inflate(getContext(), R.layout.view_realm_discovered_player_clan_item, this)
    }

    fun bindItems(items: List<RealmPlayerViewDataWrapper>, clan: String) {
        realm_discovered_players_clan_item_clan.text = clan
        items.forEach {
            realm_discovered_players_clan_item_players.addView(RealmDiscoveredPlayerView(context).apply {
                bindItem(it)
            })
        }
    }
}