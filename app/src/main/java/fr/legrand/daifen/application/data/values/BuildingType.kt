package fr.legrand.daifen.application.data.values

enum class BuildingType(val value: String) {
    //Global buildings
    MINE("Mine"),
    QUARRY("Carrière"),
    BARRICADES("Barricades"),
    MARKET("Marché"),
    WATCH_TOWER("Tour de guet"),
    BARRACK("Caserne"),
    TEMPLE("Temple"),
    LIBRARY("Bibliothèque"),

    //Elf building
    GUARD_TOWER("Tour de garde"),
    TELHIN("Telhin"),
    MELANDUHIN("Melanduhin"),

    //Orc buildings
    WALL("Mur"),
    SACRIFICE("Sacrifices"),
    OURTE("Ourte"),
    KA_BAN("Ka'Ban"),

    //Men buildings
    MILL("Moulin"),
    CHURCH("Eglise"),
    DUNGEON("Donjon"),

    //Dwarf buildings
    TAVERN("Taverne"),
    TRAP("Piège"),
    FORGE("Forge"),
    WORKSHOP("Atelier"),

    //Undead buildings
    GRAVEYARD("Cimetière"),
    MANOR("Manoir"),
    DARK_TOWER("Tour sombre"),

    //Nelrk buildings
    NEST("Nid"),
    CAMP("Campement"),
    EXTRACTOR("Extracteur"),

    //Primotaure buildings
    IVORY_TOWER("Tour d'ivoire"),
    ANCESTRAL_ROOM("Salle ancestrale"),
    STORM_TOWER("Tour des tempêtes"),
    SPIRAL_ROOM("Salle des spirales"),
    RUNES_ROOM("Salle des runes");

    companion object {
        fun fromValue(value: String): BuildingType? =
            values().find {
                it.value == value
            }
    }
}