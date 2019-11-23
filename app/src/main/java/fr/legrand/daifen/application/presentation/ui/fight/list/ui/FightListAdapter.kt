package fr.legrand.daifen.application.presentation.ui.fight.list.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import fr.legrand.daifen.application.R
import fr.legrand.daifen.application.presentation.ui.fight.list.item.FightViewDataWrapper

class FightListAdapter : RecyclerView.Adapter<FightListViewHolder>() {
    private var itemList: MutableList<FightViewDataWrapper> = mutableListOf()

    var onItemClickListener: (Int, Int) -> Unit = { _, _ -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FightListViewHolder {
        val fightView = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_fight_list_item, parent, false)
        return FightListViewHolder(
            parent.context,
            fightView
        )
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: FightListViewHolder, position: Int) {
        holder.bindItem(itemList[position], onItemClickListener)
    }

    fun setItemList(newList: List<FightViewDataWrapper>) {
        itemList.clear()
        itemList.addAll(newList)
        notifyDataSetChanged()
    }
}