package fr.legrand.daifen.application.presentation.ui.pigeon.list.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import fr.legrand.daifen.application.R
import fr.legrand.daifen.application.presentation.ui.pigeon.list.item.PigeonViewDataWrapper

class PigeonListAdapter : RecyclerView.Adapter<PigeonListViewHolder>() {
    private var itemList: MutableList<PigeonViewDataWrapper> = mutableListOf()

    var onItemClickListener: (Int) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PigeonListViewHolder {
        val gameItemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.view_pigeon_list_item, parent, false)
        return PigeonListViewHolder(
            parent.context,
            gameItemView
        )
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: PigeonListViewHolder, position: Int) {
        holder.bindItem(itemList[position], onItemClickListener)
    }

    fun setItemList(newList: List<PigeonViewDataWrapper>) {
        itemList.clear()
        itemList.addAll(newList)
        notifyDataSetChanged()
    }
}