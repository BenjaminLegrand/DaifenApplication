package fr.legrand.daifen.application.data.values

enum class TroopType(val value : String) {
    DUMMY("DUMMY");

    companion object {
        fun fromValue(value: String): TroopType? =
            values().find {
                it.value == value
            }
    }
}