package fr.legrand.daifen.application.data.values

enum class SpecialTroopType(val value : String) {
    DUMMY("DUMMY");

    companion object {
        fun fromValue(value: String): SpecialTroopType? =
            values().find {
                it.value == value
            }
    }
}