package fr.legrand.daifen.application.presentation.ui.order.item

import android.content.Context
import fr.legrand.daifen.application.R
import fr.legrand.daifen.application.data.entity.model.Troop
import fr.legrand.daifen.application.data.values.TroopType

data class TroopViewDataWrapper(
    private val troop: Troop
) {

    constructor(troopType: TroopType, count: Int) : this(Troop(troopType, count))

    fun getTroopTypeCountText(context: Context): String {
        val type = getTroopTypeText(context)
        return "${troop.count} $type"
    }

    fun getTroopTypeText(context: Context): String = when (troop.troopType) {
        TroopType.WARRIOR -> context.resources.getQuantityString(
            R.plurals.troop_warrior,
            troop.count
        )
        TroopType.SPY -> context.resources.getQuantityString(
            R.plurals.troop_spy,
            troop.count
        )
        TroopType.SCRIBE -> context.resources.getQuantityString(
            R.plurals.troop_scribe,
            troop.count
        )
        TroopType.CARAVAN -> context.resources.getQuantityString(
            R.plurals.troop_caravan,
            troop.count
        )
        TroopType.ARCHER -> context.resources.getQuantityString(
            R.plurals.troop_archer,
            troop.count
        )
        TroopType.HORSEMAN -> context.resources.getQuantityString(
            R.plurals.troop_horseman,
            troop.count
        )
        TroopType.GUARDIAN -> context.resources.getQuantityString(
            R.plurals.troop_guardian,
            troop.count
        )
        TroopType.FAIRY -> context.resources.getQuantityString(
            R.plurals.troop_fairy,
            troop.count
        )
        TroopType.BARD -> context.resources.getQuantityString(
            R.plurals.troop_bard,
            troop.count
        )
        TroopType.SCOUT -> context.resources.getQuantityString(
            R.plurals.troop_scout,
            troop.count
        )
        TroopType.DRYAD -> context.resources.getQuantityString(
            R.plurals.troop_dryad,
            troop.count
        )
        TroopType.RANGER -> context.resources.getQuantityString(
            R.plurals.troop_ranger,
            troop.count
        )
        TroopType.CENTAUR -> context.resources.getQuantityString(
            R.plurals.troop_centaur,
            troop.count
        )
        TroopType.WAR_DANCER -> context.resources.getQuantityString(
            R.plurals.troop_war_dancer,
            troop.count, troop.count
        )
        TroopType.GOBLIN -> context.resources.getQuantityString(
            R.plurals.troop_goblin,
            troop.count
        )
        TroopType.SHAMAN -> context.resources.getQuantityString(
            R.plurals.troop_shaman,
            troop.count
        )
        TroopType.FIRMIR -> context.resources.getQuantityString(
            R.plurals.troop_firmir,
            troop.count
        )
        TroopType.ELUROS -> context.resources.getQuantityString(
            R.plurals.troop_eluros,
            troop.count
        )
        TroopType.KASTAGNEUR -> context.resources.getQuantityString(
            R.plurals.troop_kastagneur,
            troop.count
        )
        TroopType.FANATIC -> context.resources.getQuantityString(
            R.plurals.troop_fanatic,
            troop.count
        )
        TroopType.TROLL -> context.resources.getQuantityString(
            R.plurals.troop_troll,
            troop.count
        )
        TroopType.OGRE -> context.resources.getQuantityString(
            R.plurals.troop_ogre,
            troop.count
        )
        TroopType.MONK -> context.resources.getQuantityString(
            R.plurals.troop_monk,
            troop.count
        )
        TroopType.ADEPT -> context.resources.getQuantityString(
            R.plurals.troop_adept,
            troop.count
        )
        TroopType.PALADIN -> context.resources.getQuantityString(
            R.plurals.troop_paladin,
            troop.count
        )
        TroopType.TEMPLAR -> context.resources.getQuantityString(
            R.plurals.troop_templar,
            troop.count
        )
        TroopType.AMAZON -> context.resources.getQuantityString(
            R.plurals.troop_amazon,
            troop.count
        )
        TroopType.VALKYRIE -> context.resources.getQuantityString(
            R.plurals.troop_valkyrie,
            troop.count
        )
        TroopType.ASSASSIN -> context.resources.getQuantityString(
            R.plurals.troop_assassin,
            troop.count
        )
        TroopType.INQUISITOR -> context.resources.getQuantityString(
            R.plurals.troop_inquisitor,
            troop.count
        )
        TroopType.MINER -> context.resources.getQuantityString(
            R.plurals.troop_miner,
            troop.count
        )
        TroopType.BLACKSMITH -> context.resources.getQuantityString(
            R.plurals.troop_blacksmith,
            troop.count
        )
        TroopType.WEAPON_MASTER -> context.resources.getQuantityString(
            R.plurals.troop_weapon_master,
            troop.count
        )
        TroopType.GIANT_HUNTER -> context.resources.getQuantityString(
            R.plurals.troop_giant_hunter,
            troop.count
        )
        TroopType.BALLISTA -> context.resources.getQuantityString(
            R.plurals.troop_ballista,
            troop.count
        )
        TroopType.ENGINEER -> context.resources.getQuantityString(
            R.plurals.troop_engineer,
            troop.count
        )
        TroopType.CATAPULT -> context.resources.getQuantityString(
            R.plurals.troop_catapult,
            troop.count
        )
        TroopType.CROSSBOW_MAN -> context.resources.getQuantityString(
            R.plurals.troop_crossbow_man,
            troop.count
        )
        TroopType.SKELETON -> context.resources.getQuantityString(
            R.plurals.troop_skeleton,
            troop.count
        )
        TroopType.GHOUL -> context.resources.getQuantityString(
            R.plurals.troop_ghoul,
            troop.count
        )
        TroopType.ZOMBIE -> context.resources.getQuantityString(
            R.plurals.troop_zombie,
            troop.count
        )
        TroopType.HARPY -> context.resources.getQuantityString(
            R.plurals.troop_harpy,
            troop.count
        )
        TroopType.DISCIPLE -> context.resources.getQuantityString(
            R.plurals.troop_disciple,
            troop.count
        )
        TroopType.VAMPIRE -> context.resources.getQuantityString(
            R.plurals.troop_vampire,
            troop.count
        )
        TroopType.NECROMANCER -> context.resources.getQuantityString(
            R.plurals.troop_necromancer,
            troop.count
        )
        TroopType.SALAMANDER -> context.resources.getQuantityString(
            R.plurals.troop_salamander,
            troop.count
        )
        TroopType.SNAKE_MAN -> context.resources.getQuantityString(
            R.plurals.troop_snake_man,
            troop.count
        )
        TroopType.LIZARD_MAN -> context.resources.getQuantityString(
            R.plurals.troop_lizard_man,
            troop.count
        )
        TroopType.RIDER -> context.resources.getQuantityString(
            R.plurals.troop_rider,
            troop.count
        )
        TroopType.CORSAIR -> context.resources.getQuantityString(
            R.plurals.troop_corsair,
            troop.count
        )
        TroopType.LOOTER -> context.resources.getQuantityString(
            R.plurals.troop_looter,
            troop.count
        )
        TroopType.PROWLER -> context.resources.getQuantityString(
            R.plurals.troop_prowler,
            troop.count
        )
        TroopType.BATELEUR -> context.resources.getQuantityString(
            R.plurals.troop_bateleur,
            troop.count
        )
        TroopType.PUPPET -> context.resources.getQuantityString(
            R.plurals.troop_puppet,
            troop.count
        )
        TroopType.SHARPSHOOTER -> context.resources.getQuantityString(
            R.plurals.troop_sharpshooter,
            troop.count
        )
        TroopType.CORNED -> context.resources.getQuantityString(
            R.plurals.troop_corned,
            troop.count
        )
        TroopType.HIGH_CORNED -> context.resources.getQuantityString(
            R.plurals.troop_high_corned,
            troop.count
        )
        TroopType.SURVEYOR -> context.resources.getQuantityString(
            R.plurals.troop_surveyor,
            troop.count
        )
        TroopType.KOALA -> context.resources.getQuantityString(
            R.plurals.troop_koala,
            troop.count
        )
        TroopType.EAGLE -> context.resources.getQuantityString(
            R.plurals.troop_eagle,
            troop.count
        )
        TroopType.DRUID -> context.resources.getQuantityString(
            R.plurals.troop_druid,
            troop.count
        )
        TroopType.GUIDE -> context.resources.getQuantityString(
            R.plurals.troop_guide,
            troop.count
        )
        TroopType.WOLF -> context.resources.getQuantityString(
            R.plurals.troop_wolf,
            troop.count
        )
        TroopType.LION -> context.resources.getQuantityString(
            R.plurals.troop_lion,
            troop.count
        )
    }

    fun getTroopText(context: Context, currentRound: Boolean): String =
        if (currentRound) {
            context.getString(R.string.troop_text_format_current, getTroopTypeCountText(context))
        } else {
            context.getString(R.string.troop_text_format, getTroopTypeCountText(context))
        }

    fun getAttack(): Int = troop.attack * troop.count
    fun getDefense(): Int = troop.defense * troop.count
    fun getResistance(): Int = troop.resistance * troop.count
    fun getGold(): Int = troop.gold * troop.count
    fun getIntellect(): Int = troop.intellect * troop.count


}