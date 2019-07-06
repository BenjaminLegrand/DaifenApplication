package fr.legrand.daifen.application.presentation.ui.pigeon.ui

import android.content.Context
import android.graphics.Typeface
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import fr.legrand.daifen.application.R
import fr.legrand.daifen.application.presentation.ui.pigeon.item.PigeonViewDataWrapper

/**
 * Created by Benjamin on 29/04/2018.
 */
class PigeonListViewHolder(private val context: Context, pigeonView: View) :
    RecyclerView.ViewHolder(pigeonView) {

    private val pigeonEmitter = pigeonView.findViewById<TextView>(R.id.pigeon_list_item_emitter)
    private val pigeonSubject = pigeonView.findViewById<TextView>(R.id.pigeon_list_item_subject)
    private val pigeonDate = pigeonView.findViewById<TextView>(R.id.pigeon_list_item_date)

    fun bindItem(pigeon: PigeonViewDataWrapper, listener: (Int) -> Unit) {
        itemView.setOnClickListener { listener(pigeon.getId()) }
        pigeonEmitter.text = pigeon.getEmitter()
        pigeonSubject.text = pigeon.getSubject()
        pigeonDate.text = pigeon.getDate(context)
        if (pigeon.isUnread()) {
            pigeonEmitter.setTextColor(ContextCompat.getColor(context, R.color.black))
            pigeonEmitter.typeface = Typeface.DEFAULT_BOLD
            pigeonSubject.setTextColor(ContextCompat.getColor(context, R.color.black))
            pigeonSubject.typeface = Typeface.DEFAULT_BOLD
            pigeonDate.setTextColor(ContextCompat.getColor(context, R.color.black))
            pigeonDate.typeface = Typeface.DEFAULT_BOLD
        }
    }
}