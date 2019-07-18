package fr.legrand.daifen.application.data.entity.remote

import pl.droidsonroids.jspoon.annotation.Selector

data class OrderResponseRemoteEntity(
    @Selector("#connaissance b")
    var currentKnowledge: String? = null,
    @Selector("#contenu div > h2:nth-child(1) + #connaissance + p:not(#connaissance)")
    var buildingsDisabledWithKnowledge: String? = null,
    @Selector("#contenu div > h2:nth-child(1) + p:not(#connaissance)")
    var buildingsDisabledWithoutKnowledge: String? = null,
    @Selector("#contenu div > h2:nth-child(1) + #connaissance + ul + p:not(#connaissance)")
    var troopsDisabledWithKnowledgeWithBuildings: String? = null,
    @Selector("#contenu div > h2:nth-child(1) + #connaissance + p:not(#connaissance) + p:not(#connaissance)")
    var troopsDisabledWithKnowledgeWithoutBuildings: String? = null,
    @Selector("#contenu div > h2:nth-child(1) + ul + p:not(#connaissance)")
    var troopsDisabledWithoutKnowledgeWithBuildings: String? = null,
    @Selector("#contenu div > h2:nth-of-type(1) + p:not(#connaissance) + p:not(#connaissance)")
    var troopsDisabledWithoutKnowledgeWithoutBuildings: String? = null,
    @Selector("#contenu div > h2:nth-of-type(1) + #connaissance + ul li")
    var buildingsWithKnowledge: List<String> = emptyList(),
    @Selector("#contenu div > h2:nth-of-type(1) + ul li")
    var buildingsWithoutKnowledge: List<String> = emptyList(),
    @Selector("#contenu div > h2:nth-of-type(1) + #connaissance + p:not(#connaissance) + ul li")
    var troopsWithKnowledgeWithoutBuilding: List<String> = emptyList(),
    @Selector("#contenu div > h2:nth-of-type(1) + #connaissance + ul + ul li")
    var troopsWithKnowledgeWithBuildings: List<String> = emptyList(),
    @Selector("#contenu div > h2:nth-of-type(1) + p:not(#connaissance) + ul li")
    var troopsWithoutKnowledgeWithoutBuilding: List<String> = emptyList(),
    @Selector("#contenu div > h2:nth-of-type(1) + ul + ul li")
    var troopsWithoutKnowledgeWithBuildings: List<String> = emptyList(),
    @Selector("#contenu div > h2:nth-of-type(2) + p")
    var giftsDisabled: String? = null,
    @Selector("#contenu div > h2:nth-of-type(2) + ul li")
    var gifts: List<String> = emptyList(),
    @Selector("#contenu div > h2:nth-of-type(3) + p")
    var specialTroopsDisabled: String? = null,
    @Selector("#contenu div > h2:nth-of-type(3) + ul li")
    var specialTroops: List<String> = emptyList(),
    @Selector("#contenu div > h2:nth-of-type(4) + p")
    var firstAttackTarget: String? = null,
    @Selector("#contenu div > h2:nth-of-type(4) + p + ul li")
    var firstAttack: List<String>? = null,
    @Selector("#contenu div > h2:nth-of-type(4) + p + ul + p")
    var secondAttackTarget: String? = null,
    @Selector("#contenu div > h2:nth-of-type(4) + p + ul + p + ul li")
    var secondAttack: List<String>? = null,
    @Selector("#contenu div > h2:nth-of-type(4) + p + ul + p + ul + p")
    var thirdAttackTarget: String? = null,
    @Selector("#contenu div > h2:nth-of-type(4) + p + ul + p + ul + p + ul li")
    var thirdAttack: List<String>? = null,
    @Selector("#contenu div > h2:nth-of-type(5) + p")
    var firstSupportTarget: String? = null,
    @Selector("#contenu div > h2:nth-of-type(5) + p + ul li")
    var firstSupport: List<String>? = null,
    @Selector("#contenu div > h2:nth-of-type(5) + p + ul + p")
    var secondSupportTarget: String? = null,
    @Selector("#contenu div > h2:nth-of-type(5) + p + ul + p + ul li")
    var secondSupport: List<String>? = null,
    @Selector("#contenu div > h2:nth-of-type(5) + p + ul + p + ul + p")
    var thirdSupportTarget: String? = null,
    @Selector("#contenu div > h2:nth-of-type(5) + p + ul + p + ul + p + ul li")
    var thirdSupport: List<String>? = null
)
