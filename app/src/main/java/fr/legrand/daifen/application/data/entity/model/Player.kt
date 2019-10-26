package fr.legrand.daifen.application.data.entity.model

import fr.legrand.daifen.application.data.values.RaceType

data class Player(
    val name: String,
    val race: RaceType,
    val clan: String
)