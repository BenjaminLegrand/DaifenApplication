package fr.legrand.daifen.application.data.entity.remote

import pl.droidsonroids.jspoon.annotation.Selector

data class IndexResponse(
    @Selector("a[href=/continents/choix.php]")
    var newGameAvailable: String = ""
)