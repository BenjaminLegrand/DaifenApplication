package fr.legrand.daifen.application.data.entity.remote

import fr.legrand.daifen.application.data.values.KnowledgeType

data class OrdersRemoteEntity(
    var round : Int = 0,
    var knowledge: KnowledgeType? = null,
    var buildings: List<BuildingRemoteEntity> = emptyList(),
    var troops: List<TroopRemoteEntity> = emptyList(),
    var gifts: List<GiftRemoteEntity> = emptyList(),
    var specialTroops: List<SpecialTroopRemoteEntity> = emptyList(),
    var attacks: MutableList<AttackRemoteEntity> = mutableListOf(),
    var supports: MutableList<SupportRemoteEntity> = mutableListOf()
)