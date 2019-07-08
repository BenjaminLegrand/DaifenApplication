package fr.legrand.daifen.application.presentation.ui.pigeon.list.item

import android.content.Context
import fr.legrand.daifen.application.R
import fr.legrand.daifen.application.data.entity.model.Pigeon
import java.text.SimpleDateFormat
import java.util.*

class PigeonViewDataWrapper(private val pigeon: Pigeon) {
    fun getEmitter() = pigeon.emitter
    fun getSubject() = pigeon.subject
    fun getDate(context: Context): String = SimpleDateFormat(
        context.getString(R.string.piegon_date_format),
        Locale.getDefault()
    ).format(pigeon.date)
    fun getHistory() = pigeon.history

    fun getId() = pigeon.id
    fun isUnread() = pigeon.unread
}