package fr.legrand.daifen.application.presentation.ui.order.item

import android.content.Context
import fr.legrand.daifen.application.R
import fr.legrand.daifen.application.data.entity.model.Building
import fr.legrand.daifen.application.data.values.BuildingType

data class BuildingViewDataWrapper(
    private val building: Building
) {

    fun getBuildingText(context: Context, currentRound: Boolean): String =
        if (currentRound) {
            context.getString(
                R.string.building_text_format_current,
                getBuildingTypeCountText(context)
            )
        } else {
            context.getString(R.string.building_text_format, getBuildingTypeCountText(context))
        }

    fun getBuildingTypeCountText(context: Context): String =
        when (building.buildingType) {
            BuildingType.MINE -> context.resources.getQuantityString(
                R.plurals.building_mine,
                building.count,
                building.count
            )
            BuildingType.QUARRY -> context.resources.getQuantityString(
                R.plurals.building_quarry,
                building.count,
                building.count
            )
            BuildingType.BARRICADES -> context.resources.getQuantityString(
                R.plurals.building_barricades,
                building.count,
                building.count
            )
            BuildingType.MARKET -> context.resources.getQuantityString(
                R.plurals.building_market,
                building.count,
                building.count
            )
            BuildingType.WATCH_TOWER -> context.resources.getQuantityString(
                R.plurals.building_watch_tower,
                building.count,
                building.count
            )
            BuildingType.BARRACK -> context.resources.getQuantityString(
                R.plurals.building_barrack,
                building.count,
                building.count
            )
            BuildingType.TEMPLE -> context.resources.getQuantityString(
                R.plurals.building_temple,
                building.count,
                building.count
            )
            BuildingType.LIBRARY -> context.resources.getQuantityString(
                R.plurals.building_library,
                building.count,
                building.count
            )
            BuildingType.GUARD_TOWER -> context.resources.getQuantityString(
                R.plurals.building_guard_tower,
                building.count,
                building.count
            )
            BuildingType.TELHIN -> context.resources.getQuantityString(
                R.plurals.building_telhin,
                building.count,
                building.count
            )
            BuildingType.MELANDUHIN -> context.resources.getQuantityString(
                R.plurals.building_melanduhin,
                building.count,
                building.count
            )
            BuildingType.WALL -> context.resources.getQuantityString(
                R.plurals.building_wall,
                building.count,
                building.count
            )
            BuildingType.SACRIFICE -> context.resources.getQuantityString(
                R.plurals.building_sacrifice,
                building.count,
                building.count
            )
            BuildingType.OURTE -> context.resources.getQuantityString(
                R.plurals.building_ourte,
                building.count,
                building.count
            )
            BuildingType.KA_BAN -> context.resources.getQuantityString(
                R.plurals.building_kaban,
                building.count,
                building.count
            )
            BuildingType.MILL -> context.resources.getQuantityString(
                R.plurals.building_mill,
                building.count,
                building.count
            )
            BuildingType.CHURCH -> context.resources.getQuantityString(
                R.plurals.building_church,
                building.count,
                building.count
            )
            BuildingType.DUNGEON -> context.resources.getQuantityString(
                R.plurals.building_dungeon,
                building.count,
                building.count
            )
            BuildingType.TAVERN -> context.resources.getQuantityString(
                R.plurals.building_tavern,
                building.count,
                building.count
            )
            BuildingType.TRAP -> context.resources.getQuantityString(
                R.plurals.building_trap,
                building.count
            )
            BuildingType.FORGE -> context.resources.getQuantityString(
                R.plurals.building_forge,
                building.count,
                building.count
            )
            BuildingType.WORKSHOP -> context.resources.getQuantityString(
                R.plurals.building_workshop,
                building.count,
                building.count
            )
            BuildingType.GRAVEYARD -> context.resources.getQuantityString(
                R.plurals.building_graveyard,
                building.count
            )
            BuildingType.MANOR -> context.resources.getQuantityString(
                R.plurals.building_manor,
                building.count,
                building.count
            )
            BuildingType.DARK_TOWER -> context.resources.getQuantityString(
                R.plurals.building_dark_tower,
                building.count,
                building.count
            )
            BuildingType.NEST -> context.resources.getQuantityString(
                R.plurals.building_nest,
                building.count,
                building.count
            )
            BuildingType.CAMP -> context.resources.getQuantityString(
                R.plurals.building_camp,
                building.count,
                building.count
            )
            BuildingType.EXTRACTOR -> context.resources.getQuantityString(
                R.plurals.building_extractor,
                building.count,
                building.count
            )
            BuildingType.IVORY_TOWER -> context.resources.getQuantityString(
                R.plurals.building_ivory_tower,
                building.count,
                building.count
            )
            BuildingType.ANCESTRAL_ROOM -> context.resources.getQuantityString(
                R.plurals.building_ancestral_room,
                building.count,
                building.count
            )
            BuildingType.STORM_TOWER -> context.resources.getQuantityString(
                R.plurals.building_storm_tower,
                building.count,
                building.count
            )
            BuildingType.SPIRAL_ROOM -> context.resources.getQuantityString(
                R.plurals.building_spiral_tower,
                building.count,
                building.count
            )
            BuildingType.RUNES_ROOM -> context.resources.getQuantityString(
                R.plurals.building_runes_room,
                building.count,
                building.count
            )
        }

    fun getAttack() = building.attack
    fun getResistance() = building.resistance
    fun getGoldIncome() = building.goldIncome
    fun getIntellectIncome() = building.intellectIncome

}