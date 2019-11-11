package fr.legrand.daifen.application.data.entity.remote

import pl.droidsonroids.jspoon.annotation.Selector

data class FightListResponse(
    @Selector("#fight")
    var attacks: List<FightRemoteEntity> = emptyList(),
    @Selector("#fight")
    var defenses: List<FightRemoteEntity> = emptyList(),
    @Selector("#fight")
    var supports: List<FightRemoteEntity> = emptyList()
)