package fr.legrand.daifen.application.data.entity.remote

import pl.droidsonroids.jspoon.annotation.Selector

data class FightListResponse(
    @Selector("#contenu table:nth-of-type(1) .even, #contenu table:nth-of-type(1) .odd")
    var attacks: List<FightListItemRemoteEntity> = emptyList(),
    @Selector("#contenu table:nth-of-type(2) .even, #contenu table:nth-of-type(2) .odd")
    var defens: List<FightListItemRemoteEntity> = emptyList(),
    @Selector("#contenu table:nth-of-type(3) .even, #contenu table:nth-of-type(3) .odd")
    var supports: List<FightListItemRemoteEntity> = emptyList()
)