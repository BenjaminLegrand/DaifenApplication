package fr.legrand.daifen.application.presentation.ui.order.item

import android.content.Context
import fr.legrand.daifen.application.R
import fr.legrand.daifen.application.data.values.BuildingType

data class BuildingViewDataWrapper(
    private val buildingType: BuildingType,
    private val count: Int
) {
    fun getBuildingTypeCountText(context: Context): String {
        val type = when (buildingType) {
            BuildingType.MINE -> context.resources.getQuantityString(R.plurals.building_mine, count)
            BuildingType.QUARRY -> context.resources.getQuantityString(
                R.plurals.building_quarry,
                count
            )
            BuildingType.BARRICADES -> context.resources.getQuantityString(
                R.plurals.building_barricades,
                count
            )
            BuildingType.MARKET -> context.resources.getQuantityString(
                R.plurals.building_market,
                count
            )
            BuildingType.WATCH_TOWER -> context.resources.getQuantityString(
                R.plurals.building_watch_tower,
                count
            )
            BuildingType.BARRACK -> context.resources.getQuantityString(
                R.plurals.building_barrack,
                count
            )
            BuildingType.TEMPLE -> context.resources.getQuantityString(
                R.plurals.building_temple,
                count
            )
            BuildingType.LIBRARY -> context.resources.getQuantityString(
                R.plurals.building_library,
                count
            )
            BuildingType.GUARD_TOWER -> context.resources.getQuantityString(
                R.plurals.building_guard_tower,
                count
            )
            BuildingType.TELHIN -> context.resources.getQuantityString(
                R.plurals.building_telhin,
                count
            )
            BuildingType.MELANDUHIN -> context.resources.getQuantityString(
                R.plurals.building_melanduhin,
                count
            )
            BuildingType.WALL -> context.resources.getQuantityString(R.plurals.building_wall, count)
            BuildingType.SACRIFICE -> context.resources.getQuantityString(
                R.plurals.building_sacrifice,
                count
            )
            BuildingType.OURTE -> context.resources.getQuantityString(
                R.plurals.building_ourte,
                count
            )
            BuildingType.KA_BAN -> context.resources.getQuantityString(
                R.plurals.building_kaban,
                count
            )
            BuildingType.MILL -> context.resources.getQuantityString(R.plurals.building_mill, count)
            BuildingType.CHURCH -> context.resources.getQuantityString(
                R.plurals.building_church,
                count
            )
            BuildingType.DUNGEON -> context.resources.getQuantityString(
                R.plurals.building_dungeon,
                count
            )
            BuildingType.TAVERN -> context.resources.getQuantityString(
                R.plurals.building_tavern,
                count
            )
            BuildingType.TRAP -> context.resources.getQuantityString(R.plurals.building_trap, count)
            BuildingType.FORGE -> context.resources.getQuantityString(
                R.plurals.building_forge,
                count
            )
            BuildingType.WORKSHOP -> context.resources.getQuantityString(
                R.plurals.building_workshop,
                count
            )
            BuildingType.GRAVEYARD -> context.resources.getQuantityString(
                R.plurals.building_graveyard,
                count
            )
            BuildingType.MANOR -> context.resources.getQuantityString(
                R.plurals.building_manor,
                count
            )
            BuildingType.DARK_TOWER -> context.resources.getQuantityString(
                R.plurals.building_dark_tower,
                count
            )
            BuildingType.NEST -> context.resources.getQuantityString(R.plurals.building_nest, count)
            BuildingType.CAMP -> context.resources.getQuantityString(R.plurals.building_camp, count)
            BuildingType.EXTRACTOR -> context.resources.getQuantityString(
                R.plurals.building_extractor,
                count
            )
            BuildingType.IVORY_TOWER -> context.resources.getQuantityString(
                R.plurals.building_ivory_tower,
                count
            )
            BuildingType.ANCESTRAL_ROOM -> context.resources.getQuantityString(
                R.plurals.building_ancestral_room,
                count
            )
            BuildingType.STORM_TOWER -> context.resources.getQuantityString(
                R.plurals.building_storm_tower,
                count
            )
            BuildingType.SPIRAL_ROOM -> context.resources.getQuantityString(
                R.plurals.building_spiral_tower,
                count
            )
            BuildingType.RUNES_ROOM -> context.resources.getQuantityString(
                R.plurals.building_runes_room,
                count
            )
        }

        return "$count $type"
    }

    fun getBuildingText(context: Context): String =
        context.getString(R.string.building_text_format, getBuildingTypeCountText(context))
}