package fr.legrand.daifen.application.data.entity.model

import java.util.*

data class Pigeon(
    val id: Int,
    val emitter: Player,
    val receivers: List<String>,
    val subject: String,
    val date: Date,
    val content: String = "",
    val history: List<String> = emptyList(),
    var unread: Boolean = true
)