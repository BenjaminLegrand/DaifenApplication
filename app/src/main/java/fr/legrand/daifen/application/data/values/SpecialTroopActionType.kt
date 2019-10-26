package fr.legrand.daifen.application.data.values

enum class SpecialTroopActionType(val value : String) {
    EXPLORE("Explorer"),
    SPY("Espionner"),
    COUNTER_SPY("Contre-espionner"),
    STEAL("Voler"),
    SABOTAGE("Saboter"),
    MURDER("Assassiner"),
    SHOW("Indiquer"),
    GIVE("Donner");

    companion object {
        fun fromValue(value: String): SpecialTroopActionType? =
            values().find {
                it.value == value
            }
    }
}