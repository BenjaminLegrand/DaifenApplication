package fr.legrand.daifen.application.data.entity.remote

import pl.droidsonroids.jspoon.annotation.Selector

data class FightResponse(
    @Selector("tr.even .multia:nth-of-type(1) p a", attr = "href")
    var attackersUrls: List<String> = emptyList(),
    @Selector("tr.even .multia:nth-of-type(2) p a")
    var defendersNames: List<String> = emptyList(),
    @Selector("tr.even .multia:nth-of-type(2) p a", attr = "href")
    var defendersUrls: List<String> = emptyList(),
    @Selector("tr.even .multia:nth-of-type(1) ul li")
    var attackersTroops: List<String> = emptyList(),
    @Selector("tr.even .multia:nth-of-type(2) ul li")
    var defendersTroops: List<String> = emptyList(),
    @Selector("tr.odd td:nth-of-type(1) ul li")
    var attackersLosses: List<String> = emptyList(),
    @Selector("tr.odd td:nth-of-type(2) ul li")
    var defendersLosses: List<String> = emptyList(),
    @Selector("td.even ul li")
    var destroyedBuildings: List<String> = emptyList()
)