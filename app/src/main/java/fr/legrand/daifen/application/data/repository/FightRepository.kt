package fr.legrand.daifen.application.data.repository

import fr.legrand.daifen.application.data.entity.model.Fight
import fr.legrand.daifen.application.data.entity.model.Player
import fr.legrand.daifen.application.data.entity.model.Troop
import fr.legrand.daifen.application.data.manager.api.ApiManager
import fr.legrand.daifen.application.data.values.FightType
import fr.legrand.daifen.application.data.values.ReferentialValues
import fr.legrand.daifen.application.data.values.TroopType
import io.reactivex.Single

class FightRepository(
    private val apiManager: ApiManager
) {
    fun retrieveFightList(): Single<List<Fight>> {
        return Single.just(
            listOf(
                Fight(
                    1,
                    FightType.ATTACK,
                    listOf(
                        Player(
                            1,
                            "Attacker1",
                            "https://static.fnac-static.com/multimedia/Images/32/39/38/35/5892374-1505-1540-1/tsp20171018110614/Masque-Carton-Kermit-La-Grenouille-Les-Muppets-Show.jpg"
                        ),
                        Player(
                            2,
                            "Attacker2",
                            "https://i.kym-cdn.com/photos/images/newsfeed/001/398/111/d5a"
                        )
                    ),
                    listOf(
                        Player(
                            1,
                            "Defender1",
                            "https://static.fnac-static.com/multimedia/Images/32/39/38/35/5892374-1505-1540-1/tsp20171018110614/Masque-Carton-Kermit-La-Grenouille-Les-Muppets-Show.jpg"
                        ),
                        Player(
                            2,
                            "Defender2",
                            "https://i.kym-cdn.com/photos/images/newsfeed/001/398/111/d5a"
                        )
                    ),
                    listOf(),
                    listOf(),
                    listOf(),
                    listOf(),
                    listOf()
                ),
                Fight(
                    1,
                    FightType.DEFENSE,
                    listOf(
                        Player(
                            1,
                            "Attacker1",
                            "https://static.fnac-static.com/multimedia/Images/32/39/38/35/5892374-1505-1540-1/tsp20171018110614/Masque-Carton-Kermit-La-Grenouille-Les-Muppets-Show.jpg"
                        ),
                        Player(
                            2,
                            "Attacker2",
                            "https://i.kym-cdn.com/photos/images/newsfeed/001/398/111/d5a"
                        )
                    ),
                    listOf(
                        Player(
                            1,
                            "Defender1",
                            "https://static.fnac-static.com/multimedia/Images/32/39/38/35/5892374-1505-1540-1/tsp20171018110614/Masque-Carton-Kermit-La-Grenouille-Les-Muppets-Show.jpg"
                        ),
                        Player(
                            2,
                            "Defender2",
                            "https://i.kym-cdn.com/photos/images/newsfeed/001/398/111/d5a"
                        )
                    ),
                    listOf(),
                    listOf(),
                    listOf(),
                    listOf(),
                    listOf()
                ),
                Fight(
                    1,
                    FightType.SUPPORT,
                    listOf(
                        Player(
                            1,
                            "Attacker1",
                            "https://static.fnac-static.com/multimedia/Images/32/39/38/35/5892374-1505-1540-1/tsp20171018110614/Masque-Carton-Kermit-La-Grenouille-Les-Muppets-Show.jpg"
                        ),
                        Player(
                            2,
                            "Attacker2",
                            "https://i.kym-cdn.com/photos/images/newsfeed/001/398/111/d5a"
                        )
                    ),
                    listOf(
                        Player(
                            1,
                            "Defender1",
                            "https://static.fnac-static.com/multimedia/Images/32/39/38/35/5892374-1505-1540-1/tsp20171018110614/Masque-Carton-Kermit-La-Grenouille-Les-Muppets-Show.jpg"
                        ),
                        Player(
                            2,
                            "Defender2",
                            "https://i.kym-cdn.com/photos/images/newsfeed/001/398/111/d5a"
                        )
                    ),
                    listOf(),
                    listOf(),
                    listOf(),
                    listOf(),
                    listOf()
                )
            )
        )
    }

    fun retrieveFight(id: Int): Single<Fight> {
        return Single.just(
            Fight(
                1,
                FightType.ATTACK,
                listOf(
                    Player(
                        1,
                        "Attacker1",
                        "https://static.fnac-static.com/multimedia/Images/32/39/38/35/5892374-1505-1540-1/tsp20171018110614/Masque-Carton-Kermit-La-Grenouille-Les-Muppets-Show.jpg"
                    ),
                    Player(
                        2,
                        "Attacker2",
                        "https://i.kym-cdn.com/photos/images/newsfeed/001/398/111/d5a"
                    )
                ),
                listOf(
                    Player(
                        1,
                        "Defender1",
                        "https://static.fnac-static.com/multimedia/Images/32/39/38/35/5892374-1505-1540-1/tsp20171018110614/Masque-Carton-Kermit-La-Grenouille-Les-Muppets-Show.jpg"
                    ),
                    Player(
                        2,
                        "Defender2",
                        "https://i.kym-cdn.com/photos/images/newsfeed/001/398/111/d5a"
                    )
                ),
                listOf(
                    Troop(TroopType.ADEPT, 4),
                    Troop(TroopType.ASSASSIN, 8),
                    Troop(TroopType.BARD, 1),
                    Troop(TroopType.DRYAD, 12)
                ),
                listOf(
                    Troop(TroopType.BLACKSMITH, 89),
                    Troop(TroopType.CATAPULT, 37),
                    Troop(TroopType.GOBLIN, 1),
                    Troop(TroopType.RIDER, 12),
                    Troop(TroopType.ELUROS, 12)
                ),
                listOf(
                    Troop(TroopType.ADEPT, 4),
                    Troop(TroopType.ASSASSIN, 8),
                    Troop(TroopType.BARD, 1),
                    Troop(TroopType.DRYAD, 12)
                ),
                listOf(
                    Troop(TroopType.BLACKSMITH, 8),
                    Troop(TroopType.CATAPULT, 7),
                    Troop(TroopType.RIDER, 6)
                ),
                listOf()
            )
        ).map {
            (it.attackersTroops + it.defendersTroops).forEach { troop ->
                troop.attack = (ReferentialValues.TROOP_REFERENTIAL[troop.troopType]?.attack ?: 0)
                troop.defense = (ReferentialValues.TROOP_REFERENTIAL[troop.troopType]?.defense ?: 0)
                troop.resistance =
                    (ReferentialValues.TROOP_REFERENTIAL[troop.troopType]?.resistance ?: 0)
                troop.gold = (ReferentialValues.TROOP_REFERENTIAL[troop.troopType]?.gold ?: 0)
                troop.intellect =
                    (ReferentialValues.TROOP_REFERENTIAL[troop.troopType]?.intellect ?: 0)
            }
            it
        }
    }
}