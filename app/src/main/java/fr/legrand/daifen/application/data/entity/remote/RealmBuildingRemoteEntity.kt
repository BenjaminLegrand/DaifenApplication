package fr.legrand.daifen.application.data.entity.remote

import pl.droidsonroids.jspoon.annotation.Selector

data class RealmBuildingRemoteEntity(
    @Selector("td:nth-of-type(1)")
    var buildingType: String = "",
    @Selector("td:nth-of-type(2)")
    var count: String = "",
    @Selector("td:nth-of-type(3)")
    var attack: String = "",
    @Selector("td:nth-of-type(4)")
    var resistance: String = "",
    @Selector("td:nth-of-type(5)")
    var goldIncome: String = "",
    @Selector("td:nth-of-type(6)")
    var intellectIncome: String = ""
)
