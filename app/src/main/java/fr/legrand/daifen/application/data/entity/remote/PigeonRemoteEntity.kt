package fr.legrand.daifen.application.data.entity.remote

import pl.droidsonroids.jspoon.annotation.Selector

class PigeonRemoteEntity {
    @Selector("td:nth-child(1) a")
    lateinit var emitter: String
    @Selector("td:nth-child(2) a")
    lateinit var subject: String
    @Selector("td:nth-child(3)")
    lateinit var date: String
}