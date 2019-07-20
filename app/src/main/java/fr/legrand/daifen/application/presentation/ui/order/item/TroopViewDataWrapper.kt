package fr.legrand.daifen.application.presentation.ui.order.item

import android.content.Context
import fr.legrand.daifen.application.R
import fr.legrand.daifen.application.data.values.TroopType

data class TroopViewDataWrapper(
    private val troopType: TroopType,
    private val count: Int
) {
    fun getTroopTypeCountText(context: Context): String {
        val type = getTroopTypeText(context)
        return "$count $type"
    }

    fun getTroopTypeText(context: Context): String = when (troopType) {
        TroopType.WARRIOR -> context.resources.getQuantityString(R.plurals.troop_warrior, count)
        TroopType.SPY -> context.resources.getQuantityString(R.plurals.troop_spy, count)
        TroopType.SCRIBE -> context.resources.getQuantityString(R.plurals.troop_scribe, count)
        TroopType.CARAVAN -> context.resources.getQuantityString(R.plurals.troop_caravan, count)
        TroopType.ARCHER -> context.resources.getQuantityString(R.plurals.troop_archer, count)
        TroopType.HORSEMAN -> context.resources.getQuantityString(
            R.plurals.troop_horseman,
            count
        )
        TroopType.GUARDIAN -> context.resources.getQuantityString(
            R.plurals.troop_guardian,
            count
        )
        TroopType.FAIRY -> context.resources.getQuantityString(R.plurals.troop_fairy, count)
        TroopType.BARD -> context.resources.getQuantityString(R.plurals.troop_bard, count)
        TroopType.SCOUT -> context.resources.getQuantityString(R.plurals.troop_scout, count)
        TroopType.DRYAD -> context.resources.getQuantityString(R.plurals.troop_dryad, count)
        TroopType.RANGER -> context.resources.getQuantityString(R.plurals.troop_ranger, count)
        TroopType.CENTAUR -> context.resources.getQuantityString(R.plurals.troop_centaur, count)
        TroopType.WAR_DANCER -> context.resources.getQuantityString(
            R.plurals.troop_war_dancer,
            count
        )
        TroopType.GOBLIN -> context.resources.getQuantityString(R.plurals.troop_goblin, count)
        TroopType.SHAMAN -> context.resources.getQuantityString(R.plurals.troop_shaman, count)
        TroopType.FIRMIR -> context.resources.getQuantityString(R.plurals.troop_firmir, count)
        TroopType.ELUROS -> context.resources.getQuantityString(R.plurals.troop_eluros, count)
        TroopType.KASTAGNEUR -> context.resources.getQuantityString(
            R.plurals.troop_kastagneur,
            count
        )
        TroopType.FANATIC -> context.resources.getQuantityString(R.plurals.troop_fanatic, count)
        TroopType.TROLL -> context.resources.getQuantityString(R.plurals.troop_troll, count)
        TroopType.OGRE -> context.resources.getQuantityString(R.plurals.troop_ogre, count)
        TroopType.MONK -> context.resources.getQuantityString(R.plurals.troop_monk, count)
        TroopType.ADEPT -> context.resources.getQuantityString(R.plurals.troop_adept, count)
        TroopType.PALADIN -> context.resources.getQuantityString(R.plurals.troop_paladin, count)
        TroopType.TEMPLAR -> context.resources.getQuantityString(R.plurals.troop_templar, count)
        TroopType.AMAZON -> context.resources.getQuantityString(R.plurals.troop_amazon, count)
        TroopType.VALKYRIE -> context.resources.getQuantityString(
            R.plurals.troop_valkyrie,
            count
        )
        TroopType.ASSASSIN -> context.resources.getQuantityString(
            R.plurals.troop_assassin,
            count
        )
        TroopType.INQUISITOR -> context.resources.getQuantityString(
            R.plurals.troop_inquisitor,
            count
        )
        TroopType.MINER -> context.resources.getQuantityString(R.plurals.troop_miner, count)
        TroopType.BLACKSMITH -> context.resources.getQuantityString(
            R.plurals.troop_blacksmith,
            count
        )
        TroopType.WEAPON_MASTER -> context.resources.getQuantityString(
            R.plurals.troop_weapon_master,
            count
        )
        TroopType.GIANT_HUNTER -> context.resources.getQuantityString(
            R.plurals.troop_giant_hunter,
            count
        )
        TroopType.BALLISTA -> context.resources.getQuantityString(
            R.plurals.troop_ballista,
            count
        )
        TroopType.ENGINEER -> context.resources.getQuantityString(
            R.plurals.troop_engineer,
            count
        )
        TroopType.CATAPULT -> context.resources.getQuantityString(
            R.plurals.troop_catapult,
            count
        )
        TroopType.CROSSBOW_MAN -> context.resources.getQuantityString(
            R.plurals.troop_crossbow_man,
            count
        )
        TroopType.SKELETON -> context.resources.getQuantityString(
            R.plurals.troop_skeleton,
            count
        )
        TroopType.GHOUL -> context.resources.getQuantityString(R.plurals.troop_ghoul, count)
        TroopType.ZOMBIE -> context.resources.getQuantityString(R.plurals.troop_zombie, count)
        TroopType.HARPY -> context.resources.getQuantityString(R.plurals.troop_harpy, count)
        TroopType.DISCIPLE -> context.resources.getQuantityString(
            R.plurals.troop_disciple,
            count
        )
        TroopType.VAMPIRE -> context.resources.getQuantityString(R.plurals.troop_vampire, count)
        TroopType.NECROMANCER -> context.resources.getQuantityString(
            R.plurals.troop_necromancer,
            count
        )
        TroopType.SALAMANDER -> context.resources.getQuantityString(
            R.plurals.troop_salamander,
            count
        )
        TroopType.SNAKE_MAN -> context.resources.getQuantityString(
            R.plurals.troop_snake_man,
            count
        )
        TroopType.LIZARD_MAN -> context.resources.getQuantityString(
            R.plurals.troop_lizard_man,
            count
        )
        TroopType.RIDER -> context.resources.getQuantityString(R.plurals.troop_rider, count)
        TroopType.CORSAIR -> context.resources.getQuantityString(R.plurals.troop_corsair, count)
        TroopType.LOOTER -> context.resources.getQuantityString(R.plurals.troop_looter, count)
        TroopType.PROWLER -> context.resources.getQuantityString(R.plurals.troop_prowler, count)
        TroopType.BATELEUR -> context.resources.getQuantityString(
            R.plurals.troop_bateleur,
            count
        )
        TroopType.PUPPET -> context.resources.getQuantityString(R.plurals.troop_puppet, count)
        TroopType.SHARPSHOOTER -> context.resources.getQuantityString(
            R.plurals.troop_sharpshooter,
            count
        )
        TroopType.CORNED -> context.resources.getQuantityString(R.plurals.troop_corned, count)
        TroopType.HIGH_CORNED -> context.resources.getQuantityString(
            R.plurals.troop_high_corned,
            count
        )
        TroopType.SURVEYOR -> context.resources.getQuantityString(
            R.plurals.troop_surveyor,
            count
        )
        TroopType.KOALA -> context.resources.getQuantityString(R.plurals.troop_koala, count)
        TroopType.EAGLE -> context.resources.getQuantityString(R.plurals.troop_eagle, count)
        TroopType.DRUID -> context.resources.getQuantityString(R.plurals.troop_druid, count)
        TroopType.GUIDE -> context.resources.getQuantityString(R.plurals.troop_guide, count)
        TroopType.WOLF -> context.resources.getQuantityString(R.plurals.troop_wolf, count)
        TroopType.LION -> context.resources.getQuantityString(R.plurals.troop_lion, count)
    }

    fun getTroopText(context: Context, currentRound: Boolean): String =
        if (currentRound) {
            context.getString(R.string.troop_text_format_current, getTroopTypeCountText(context))
        } else {
            context.getString(R.string.troop_text_format, getTroopTypeCountText(context))
        }

}