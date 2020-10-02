package fr.legrand.daifen.application.presentation.ui.pigeon.list.item

import android.content.Context
import fr.legrand.daifen.application.R
import fr.legrand.daifen.application.data.entity.model.Pigeon
import fr.legrand.daifen.application.presentation.ui.player.item.PlayerViewDataWrapper
import java.text.SimpleDateFormat
import java.util.*

private const val RECEIVERS_SEPARATOR = " / "

class PigeonViewDataWrapper(private val pigeon: Pigeon) {

    private val emitter = PlayerViewDataWrapper(pigeon.emitter)

    fun getEmitterName() = emitter.getName()
    fun getSubject() = pigeon.subject
    fun getDate(context: Context): String = SimpleDateFormat(
        context.getString(R.string.piegon_date_format),
        Locale.getDefault()
    ).format(pigeon.date)

    fun getHistory() = pigeon.history

    fun getId() = pigeon.id
    fun isUnread() = pigeon.unread
    fun getEmitterImageUrl() = emitter.getImageUrl()
    fun getContent() = pigeon.content
    fun getReceivers(): String = pigeon.receivers.joinToString(RECEIVERS_SEPARATOR)
}