package fr.legrand.daifen.application.data.entity.model

import fr.legrand.daifen.application.data.values.KnowledgeType

data class Knowledge(
    val type: KnowledgeType,
    val round: Int
)