package fr.legrand.daifen.application.presentation.ui.fight.list.ui

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import fr.legrand.daifen.application.presentation.extensions.hide
import fr.legrand.daifen.application.presentation.extensions.show
import fr.legrand.daifen.application.presentation.ui.fight.list.item.FightViewDataWrapper
import kotlinx.android.synthetic.main.view_fight_list_item.view.*

/**
 * Created by Benjamin on 29/04/2018.
 */
class FightListViewHolder(private val context: Context, fightView: View) :
    RecyclerView.ViewHolder(fightView) {

    fun bindItem(fight: FightViewDataWrapper, listener: (Int) -> Unit) {
        with(itemView) {
            setOnClickListener { listener(fight.getId()) }
            fight_list_item_attackers_names.text = fight.getAttackersNamesText()
            fight_list_item_defenders_names.text = fight.getDefendersNamesText()

            fight_list_item_type_icon.setImageResource(fight.getAttackTypeIconResource())
            if (fight.isAttack()) {
                fight_list_item_attack_type_direction.setImageResource(fight.getAttackDirectionIconResource())
                fight_list_item_attack_type_direction.show()
            } else {
                fight_list_item_attack_type_direction.hide()
            }
        }
    }
}