package fr.legrand.daifen.application.presentation.ui.pigeon.item

import fr.legrand.daifen.application.data.entity.model.Pigeon

class PigeonViewDataWrapper(private val pigeon: Pigeon) {
    fun getEmitter() = pigeon.emitter
    fun getSubject() = pigeon.subject
}