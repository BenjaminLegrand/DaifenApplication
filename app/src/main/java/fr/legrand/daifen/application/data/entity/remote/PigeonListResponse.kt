package fr.legrand.daifen.application.data.entity.remote

import pl.droidsonroids.jspoon.annotation.Selector

data class PigeonListResponse(
    @Selector("#formpigeons .even, #formpigeons .odd")
    var pigeonRemoteList: List<PigeonRemoteEntity> = emptyList()
)
