package fr.legrand.daifen.application.presentation.ui.pigeon.detail.ui

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import fr.legrand.daifen.application.R
import kotlinx.android.synthetic.main.view_pigeon_history_item.view.*


class PigeonHistoryItemView(context: Context?, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    ConstraintLayout(context, attrs, defStyleAttr) {

    //Used for auto inflating in XML
    constructor(context: Context?, attrs: AttributeSet? = null) : this(context, attrs, 0)

    constructor(context: Context?) : this(context, null)

    init {
        inflate(getContext(), R.layout.view_pigeon_history_item, this)
    }

    fun bindItem(item: String) {
        pigeon_history_message.text = item
    }
}