package fr.legrand.daifen.application.presentation.ui.realm.item

import fr.legrand.daifen.application.data.entity.model.Player

data class PlayerViewDataWrapper(
    private val player: Player
) {

    fun getName() = player.name
}