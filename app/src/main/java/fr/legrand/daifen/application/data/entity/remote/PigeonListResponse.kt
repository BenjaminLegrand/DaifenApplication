package fr.legrand.daifen.application.data.entity.remote

import pl.droidsonroids.jspoon.annotation.Selector

class PigeonListResponse {
    @Selector("#formpigeons .even, #formpigeons .odd")
    lateinit var pigeonRemoteList: List<PigeonRemoteEntity>
}
