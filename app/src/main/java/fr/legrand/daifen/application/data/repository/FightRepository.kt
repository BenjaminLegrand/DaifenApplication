package fr.legrand.daifen.application.data.repository

import fr.legrand.daifen.application.data.entity.model.Fight
import fr.legrand.daifen.application.data.entity.model.Player
import fr.legrand.daifen.application.data.manager.api.ApiManager
import fr.legrand.daifen.application.data.values.FightType
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
                            "http://geekfitlifestyle.com/wp-content/uploads/2019/04/kermit_rain_meme_geekfitlifestyle.jpg"
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
                            "http://geekfitlifestyle.com/wp-content/uploads/2019/04/kermit_rain_meme_geekfitlifestyle.jpg"
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
                            "http://geekfitlifestyle.com/wp-content/uploads/2019/04/kermit_rain_meme_geekfitlifestyle.jpg"
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
                            "http://geekfitlifestyle.com/wp-content/uploads/2019/04/kermit_rain_meme_geekfitlifestyle.jpg"
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
                            "http://geekfitlifestyle.com/wp-content/uploads/2019/04/kermit_rain_meme_geekfitlifestyle.jpg"
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
                            "http://geekfitlifestyle.com/wp-content/uploads/2019/04/kermit_rain_meme_geekfitlifestyle.jpg"
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
                        "http://geekfitlifestyle.com/wp-content/uploads/2019/04/kermit_rain_meme_geekfitlifestyle.jpg"
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
                        "http://geekfitlifestyle.com/wp-content/uploads/2019/04/kermit_rain_meme_geekfitlifestyle.jpg"
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
    }
}