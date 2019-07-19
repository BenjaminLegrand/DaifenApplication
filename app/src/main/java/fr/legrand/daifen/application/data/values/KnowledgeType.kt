package fr.legrand.daifen.application.data.values

enum class KnowledgeType(val value: String) {
    //Global knowledges
    PULLEY("Poulies"),
    ARCHITECTURE("Architecture"),

    //Elf knwoledge
    ARROWS("Flèches"),
    HORSE("Cheval"),
    MYSTICISM("Mysticisme"),
    EXPLORATION("Exploration"),

    //Orc knowledge
    SIZE("Taille"),
    FANATISM("Fanatisme"),
    GROZ_PAT("Groz'Pat"),
    MAN_HIP("Man'Hip"),

    //Men knowledge
    RELIGION("Religion"),
    CRUSADE("Croisades"),

    //Dwarf knowledge
    METAL("Metal"),
    MACE("Massues"),

    //Undead knowledge
    RAPACITY("Vampirisme"),
    TERROR("Terreur"),

    //Nelrk knowledge
    RUNES("Runes"),

    //Primotaure knowledge
    IGNEOUS_SMOKE("Fumées Ignées"),
    DREAM_SMOKE("Fumées Oniriques"),
    BROWN_SMOKE("Fumées Brunes"),
    PURPLE_SMOKE("Fumées Pourpres");

    companion object {
        fun fromValue(value: String): KnowledgeType? =
            values().find {
                it.value == value
            }
    }

}