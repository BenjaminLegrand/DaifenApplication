package fr.legrand.daifen.application.data.entity.model

import fr.legrand.daifen.application.data.values.KnowledgeType

data class Orders(
    var round : Int = 0,
    var knowledge: KnowledgeType? = null,
    var buildings: List<Building> = emptyList(),
    var troops: List<Troop> = emptyList(),
    var gifts: List<Gift> = emptyList(),
    var specialTroops: List<SpecialTroop> = emptyList(),
    var attacks: List<Attack> = emptyList(),
    var supports: List<Support> = emptyList()
)