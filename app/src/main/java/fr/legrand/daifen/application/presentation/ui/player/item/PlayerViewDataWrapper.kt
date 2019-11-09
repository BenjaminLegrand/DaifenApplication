package fr.legrand.daifen.application.presentation.ui.player.item

import fr.legrand.daifen.application.data.entity.model.Player

data class PlayerViewDataWrapper(
    private val player: Player
) {
    fun getImageUrl() = player.imageUrl
    fun getName() = player.name
}