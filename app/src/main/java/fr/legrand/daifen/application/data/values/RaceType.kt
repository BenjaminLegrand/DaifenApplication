package fr.legrand.daifen.application.data.values

enum class RaceType(val value: String) {
    DWARF("Nain"),
    UNDEAD("Mort-Vivant"),
    HUMAN("Humain"),
    NELRK("Nelrk"),
    ELF("Elfe"),
    ORC("Orc"),
    PRIMOTAURE("Primotaure");

    companion object {
        fun fromValue(value: String): RaceType? =
            RaceType.values().find {
                it.value == value
            }
    }
}