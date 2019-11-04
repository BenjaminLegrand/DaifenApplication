package fr.legrand.daifen.application.data.entity.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class PigeonDBEntity(
    @PrimaryKey
    var id: Int = 0,
    var emitter: String = "",
    var receivers : List<String> = emptyList(),
    var subject: String = "",
    var date: Date = Date(),
    val emitterImage: String = "",
    val content: String = "",
    val history: List<String> = emptyList(),
    val unread: Boolean = true
)