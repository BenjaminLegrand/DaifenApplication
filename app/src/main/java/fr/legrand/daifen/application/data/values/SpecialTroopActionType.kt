package fr.legrand.daifen.application.data.values

enum class SpecialTroopActionType(val value : String) {
    DUMMY("DUMMY");

    companion object {
        fun fromValue(value: String): SpecialTroopActionType? =
            values().find {
                it.value == value
            }
    }
}