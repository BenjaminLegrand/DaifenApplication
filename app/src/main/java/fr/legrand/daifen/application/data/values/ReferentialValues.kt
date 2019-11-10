package fr.legrand.daifen.application.data.values

import fr.legrand.daifen.application.data.entity.model.TroopCharacteristics

object ReferentialValues {
    val TROOP_REFERENTIAL = mapOf(
        TroopType.WARRIOR to TroopCharacteristics(1, 1, 1, 0, 0),
        TroopType.SPY to TroopCharacteristics(0, 0, 1, 0, 0),
        TroopType.SCRIBE to TroopCharacteristics(0, 0, 1, 0, 1),
        TroopType.CARAVAN to TroopCharacteristics(0, 0, 0, 0, 0),
        TroopType.ARCHER to TroopCharacteristics(2, 2, 1, 0, 0),
        TroopType.HORSEMAN to TroopCharacteristics(2, 1, 0, 0, 0),
        TroopType.GUARDIAN to TroopCharacteristics(1, 3, 1, 0, 0),
        TroopType.FAIRY to TroopCharacteristics(0, 1, 0, 0, 0),
        TroopType.BARD to TroopCharacteristics(0, 0, 1, 0, 1),
        TroopType.SCOUT to TroopCharacteristics(3, 2, 1, 0, 0),
        TroopType.DRYAD to TroopCharacteristics(0, 0, 2, 0, 0),
        TroopType.RANGER to TroopCharacteristics(2, 2, 0, 0, 0),
        TroopType.CENTAUR to TroopCharacteristics(3, 1, 1, 0, 0),
        TroopType.WAR_DANCER to TroopCharacteristics(3, 2, 0, 0, 0),
        TroopType.GOBLIN to TroopCharacteristics(1, 0, 1, 0, 0),
        TroopType.SHAMAN to TroopCharacteristics(1, 0, 1, 0, 1),
        TroopType.FIRMIR to TroopCharacteristics(2, 3, 1, 0, 0),
        TroopType.ELUROS to TroopCharacteristics(3, 2, 2, 0, 0),
        TroopType.KASTAGNEUR to TroopCharacteristics(1, 2, 1, 0, 0),
        TroopType.FANATIC to TroopCharacteristics(3, 0, 1, 0, 0),
        TroopType.TROLL to TroopCharacteristics(3, 1, 2, 0, 0),
        TroopType.OGRE to TroopCharacteristics(2, 2, 2, 0, 0),
        TroopType.MONK to TroopCharacteristics(0, 0, 2, 0, 2),
        TroopType.ADEPT to TroopCharacteristics(1, 0, 1, 0, 0),
        TroopType.PALADIN to TroopCharacteristics(2, 2, 2, 0, 0),
        TroopType.TEMPLAR to TroopCharacteristics(1, 2, 1, 0, 1),
        TroopType.AMAZON to TroopCharacteristics(1, 1, 0, 0, 0),
        TroopType.VALKYRIE to TroopCharacteristics(2, 3, 1, 0, 0),
        TroopType.ASSASSIN to TroopCharacteristics(0, 0, 1, 0, 0),
        TroopType.INQUISITOR to TroopCharacteristics(1, 3, 2, 0, 0),
        TroopType.MINER to TroopCharacteristics(1, 0, 1, 1, 0),
        TroopType.BLACKSMITH to TroopCharacteristics(2, 2, 1, 0, 0),
        TroopType.WEAPON_MASTER to TroopCharacteristics(2, 1, 3, 0, 0),
        TroopType.GIANT_HUNTER to TroopCharacteristics(2, 2, 4, 0, 0),
        TroopType.BALLISTA to TroopCharacteristics(2, 0, 3, 0, 0),
        TroopType.ENGINEER to TroopCharacteristics(0, 0, 1, 0, 0),
        TroopType.CATAPULT to TroopCharacteristics(3, 0, 4, 0, 0),
        TroopType.CROSSBOW_MAN to TroopCharacteristics(2, 1, 2, 0, 0),
        TroopType.SKELETON to TroopCharacteristics(1, 0, 1, 0, 0),
        TroopType.GHOUL to TroopCharacteristics(2, 0, 1, 0, 0),
        TroopType.ZOMBIE to TroopCharacteristics(2, 1, 0, 0, 0),
        TroopType.HARPY to TroopCharacteristics(4, 3, 0, 0, 0),
        TroopType.DISCIPLE to TroopCharacteristics(1, 1, 0, 0, 1),
        TroopType.VAMPIRE to TroopCharacteristics(3, 2, 0, 0, 0),
        TroopType.NECROMANCER to TroopCharacteristics(1, 0, 1, 0, 0),
        TroopType.SALAMANDER to TroopCharacteristics(1, 0, 1, 0, 0),
        TroopType.SNAKE_MAN to TroopCharacteristics(2, 0, 3, 0, 0),
        TroopType.LIZARD_MAN to TroopCharacteristics(2, 2, 0, 0, 0),
        TroopType.RIDER to TroopCharacteristics(3, 1, 0, 0, 0),
        TroopType.CORSAIR to TroopCharacteristics(3, 3, 0, -1, 0),
        TroopType.LOOTER to TroopCharacteristics(0, 0, 1, 0, 0),
        TroopType.PROWLER to TroopCharacteristics(0, 0, 1, 0, 0),
        TroopType.BATELEUR to TroopCharacteristics(1, 1, 0, 0, 0),
        TroopType.PUPPET to TroopCharacteristics(1, 0, 4, 0, 0),
        TroopType.SHARPSHOOTER to TroopCharacteristics(1, 0, 3, 0, 0),
        TroopType.CORNED to TroopCharacteristics(2, 1, 1, 0, 0),
        TroopType.HIGH_CORNED to TroopCharacteristics(4, 1, 0, 0, 0),
        TroopType.SURVEYOR to TroopCharacteristics(2, 2, 0, 0, 0),
        TroopType.KOALA to TroopCharacteristics(0, 0, 1, 0, 0),
        TroopType.EAGLE to TroopCharacteristics(0, 0, 1, 0, 0),
        TroopType.DRUID to TroopCharacteristics(0, 2, 0, 0, 0),
        TroopType.GUIDE to TroopCharacteristics(0, 2, 0, 0, 0),
        TroopType.WOLF to TroopCharacteristics(1, 0, 1, 0, 0),
        TroopType.LION to TroopCharacteristics(2, 0, 1, 0, 0)
    )
}