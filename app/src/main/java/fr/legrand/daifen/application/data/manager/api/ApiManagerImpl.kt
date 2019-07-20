package fr.legrand.daifen.application.data.manager.api

import fr.legrand.daifen.application.BuildConfig
import fr.legrand.daifen.application.data.entity.remote.*
import fr.legrand.daifen.application.data.exception.AuthenticationException
import fr.legrand.daifen.application.data.values.BuildingType
import fr.legrand.daifen.application.data.values.KnowledgeType
import fr.legrand.daifen.application.data.values.SpecialTroopActionType
import fr.legrand.daifen.application.data.values.TroopType
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.HttpException


private const val HTTP_REDIRECT_CODE = 302
private const val MEMORIZE_FORM_VALUE = "on"

private const val PIGEON_DETAIL_DATE_REGEX = "le "
private const val PIGEON_DETAIL_CONVERSATION_LINE_SEPARATOR = "\n"
private const val PIGEON_DETAIL_CONVERSATION_START_SEPARATOR = '>'
private val PIGEON_DETAIL_CONVERSATION_START_REGEX = Regex(">+")
private val PIGEON_DETAIL_CONVERSATION_REGEX = Regex(">.*?(?=\\s+>|\\s*$)")
private val EMITTER_ID_REGEX = Regex("[0-9]+")

private const val CURRENT_ROUND_VALUE = 0
private val BUILDING_REGEX = Regex("(?<=Construction de).+(?=x[0-9]+)")
private val BUILDING_COUNT_REGEX = Regex("(?<=x)[0-9]+")
private val TROOP_REGEX = Regex("(?<=Entraînement de).+(?=x[0-9]+)")
private val TROOP_COUNT_REGEX = Regex("(?<=x)[0-9]+")
private val GIFT_TARGET_REGEX = Regex("(?<=pour).+")
private val GIFT_COUNT_REGEX = Regex("(?<=x)[0-9]+")
private val GIFT_TYPE_REGEX = Regex(".+(?=x[0-9]+)")
private val SPECIAL_TROOP_ACTION_REGEX = Regex("(?<=:\\s).+?(?=(\\s|\$))")
private val SPECIAL_TROOP_TYPE_REGEX = Regex(".+(?=:)")
private val SPECIAL_TROOP_ACTION_TARGET_REGEX = Regex("(?<=chez).+?(?=(pour|\$))")
private val SPECIAL_TROOP_ACTION_SHOW_TARGET_REGEX = Regex("(?<=indiquer).+?(?=($))")
private val ATTACK_TARGET_REGEX = Regex("(?<=Attaquer).+(?=avec)")
private val ATTACK_TROOP_COUNT_REGEX = Regex("^[0-9]+")
private val ATTACK_TROOP_TYPE_REGEX = Regex("[a-zA-Z]+")
private val SUPPORT_TARGET_REGEX = Regex("(?<=Soutenir).+(?=avec)")
private val SUPPORT_TROOP_COUNT_REGEX = Regex("^[0-9]+")
private val SUPPORT_TROOP_TYPE_REGEX = Regex("[a-zA-Z]+")

class ApiManagerImpl(private val apiService: ApiService) : ApiManager {


    override fun getPigeonList(page: Int): Single<List<PigeonRemoteEntity>> =
        apiService.getPigeonList(page).map {
            it.pigeonRemoteList
        }.addRedirectCheck()

    override fun getPigeon(id: Int): Single<PigeonRemoteEntity> =
        apiService.getPigeon(id).map {
            val date = it.pigeonConversationData[1].substringAfterLast(PIGEON_DETAIL_DATE_REGEX)
            //The three first items are useless : links/emitter/receiver
            val data = it.pigeonConversationData.drop(3)

            var lastMessage =
                data.take(if (data.size - 1 == 0) 1 else data.size - 1)
                    .joinToString(PIGEON_DETAIL_CONVERSATION_LINE_SEPARATOR)
            val historyMessages =
                PIGEON_DETAIL_CONVERSATION_REGEX.findAll(data.last()).map { it.value }
                    .toMutableList().asReversed()
            //Sometimes history messages are included in last message
            historyMessages.forEach {
                lastMessage = lastMessage.replace(it, "")
            }
            val fullHistory = mutableListOf<String>()
            if (historyMessages.isNotEmpty()) {
                PIGEON_DETAIL_CONVERSATION_START_REGEX.find(historyMessages.first())
                    ?.value?.length?.let { highestLevel ->
                    for (level in highestLevel downTo 1) {
                        val currentMessagesSeparator =
                            (1..level).map { PIGEON_DETAIL_CONVERSATION_START_SEPARATOR }
                                .joinToString("")
                        val currentLevelMessages = historyMessages.filter {
                            it.startsWith(currentMessagesSeparator)
                        }.asReversed()
                        fullHistory.add(currentLevelMessages.map { it.drop(level) }.filter { it.isNotBlank() }
                            .joinToString(PIGEON_DETAIL_CONVERSATION_LINE_SEPARATOR))
                        historyMessages.removeAll(currentLevelMessages)
                    }
                }
            }

            PigeonRemoteEntity().apply {
                this.id = id.toString()
                this.emitter = it.emitter
                this.emitterId = EMITTER_ID_REGEX.find(it.emitterId)?.value?.toInt() ?: 0
                this.subject = it.subject
                this.date = date
                this.content = lastMessage
                this.history = fullHistory.reversed()
            }
        }.flatMap { pigeon ->
            apiService.getPlayer(pigeon.emitterId).map {
                pigeon.emitterImage = "${BuildConfig.BASE_URL}${it.image}"
                pigeon
            }
        }

    override fun getCurrentRoundOrders(): Single<OrdersRemoteEntity> =
        getRoundOrders(CURRENT_ROUND_VALUE)

    override fun getRoundOrders(round: Int): Single<OrdersRemoteEntity> =
        apiService.getRoundOrders(round).map { orders ->
            OrdersRemoteEntity().apply {
                this.round = orders.round?.toInt() ?: 0
                knowledge = orders.currentKnowledge?.trim()?.let { KnowledgeType.fromValue(it) }
                if (orders.buildingsDisabledWithKnowledge == null && orders.buildingsDisabledWithoutKnowledge == null) {
                    buildings =
                        (orders.buildingsWithKnowledge + orders.buildingsWithoutKnowledge).mapNotNull {
                            val buildingType =
                                BuildingType.fromValue(BUILDING_REGEX.find(it)?.value?.trim() ?: "")
                            val buildingCount =
                                BUILDING_COUNT_REGEX.find(it)?.value?.trim()?.toInt() ?: 0
                            buildingType?.let {
                                BuildingRemoteEntity(it, buildingCount)
                            } ?: return@mapNotNull null
                        }
                }
                if (orders.troopsDisabledWithKnowledgeWithBuildings == null && orders.troopsDisabledWithKnowledgeWithoutBuildings == null
                    && orders.troopsDisabledWithoutKnowledgeWithBuildings == null && orders.troopsDisabledWithoutKnowledgeWithoutBuildings == null
                ) {
                    troops =
                        (orders.troopsWithKnowledgeWithBuildings + orders.troopsWithKnowledgeWithoutBuilding +
                                orders.troopsWithoutKnowledgeWithBuildings + orders.troopsWithoutKnowledgeWithoutBuilding).mapNotNull {
                            val troopType =
                                TroopType.fromValue(TROOP_REGEX.find(it)?.value?.trim() ?: "")
                            val troopCount =
                                TROOP_COUNT_REGEX.find(it)?.value?.trim()?.toInt() ?: 0
                            troopType?.let {
                                TroopRemoteEntity(it, troopCount)
                            }
                        }
                }
                if (orders.giftsDisabled == null) {
                    gifts = orders.gifts.mapNotNull { giftString ->
                        val troopType =
                            TroopType.fromValue(
                                GIFT_TYPE_REGEX.find(giftString)?.value?.trim() ?: ""
                            )
                        troopType?.let {
                            GiftRemoteEntity(
                                it,
                                GIFT_TARGET_REGEX.find(giftString)?.value?.trim() ?: "",
                                GIFT_COUNT_REGEX.find(giftString)?.value?.trim()?.toInt() ?: 0
                            )
                        }
                    }
                }
                if (orders.specialTroopsDisabled == null) {
                    specialTroops = orders.specialTroops.mapNotNull {
                        val troopType = TroopType.fromValue(
                            SPECIAL_TROOP_TYPE_REGEX.find(it)?.value?.trim() ?: ""
                        )
                        val troopAction = SpecialTroopActionType.fromValue(
                            SPECIAL_TROOP_ACTION_REGEX.find(it)?.value?.trim() ?: ""
                        )
                        var target = ""
                        var showTarget = ""
                        when (troopAction) {
                            SpecialTroopActionType.SPY,
                            SpecialTroopActionType.STEAL,
                            SpecialTroopActionType.SABOTAGE,
                            SpecialTroopActionType.MURDER,
                            SpecialTroopActionType.GIVE -> {
                                target =
                                    SPECIAL_TROOP_ACTION_TARGET_REGEX.find(it)?.value?.trim()
                                        ?: ""
                            }
                            SpecialTroopActionType.SHOW -> {
                                target =
                                    SPECIAL_TROOP_ACTION_TARGET_REGEX.find(it)?.value?.trim()
                                        ?: ""
                                showTarget =
                                    SPECIAL_TROOP_ACTION_SHOW_TARGET_REGEX.find(it)?.value?.trim()
                                        ?: ""

                            }
                            else -> {
                            }
                        }
                        return@mapNotNull if (troopType != null && troopAction != null) {
                            SpecialTroopRemoteEntity(
                                troopType,
                                troopAction,
                                target,
                                showTarget
                            )
                        } else {
                            null
                        }

                    }
                }

                val firstAttack =
                    ATTACK_TARGET_REGEX.find(orders.firstAttackTarget ?: "")?.value?.trim()
                firstAttack?.let {
                    attacks.addAttack(it, orders.firstAttack ?: emptyList())
                }
                val secondAttack =
                    ATTACK_TARGET_REGEX.find(orders.secondAttackTarget ?: "")?.value?.trim()
                secondAttack?.let {
                    attacks.addAttack(it, orders.secondAttack ?: emptyList())
                }
                val thirdAttack =
                    ATTACK_TARGET_REGEX.find(orders.thirdAttackTarget ?: "")?.value?.trim()
                thirdAttack?.let {
                    attacks.addAttack(it, orders.thirdAttack ?: emptyList())
                }

                val firstSupport =
                    SUPPORT_TARGET_REGEX.find(orders.firstSupportTarget ?: "")?.value?.trim()
                firstSupport?.let {
                    supports.addSupport(it, orders.firstSupport ?: emptyList())
                }
                val secondSupport =
                    SUPPORT_TARGET_REGEX.find(orders.secondSupportTarget ?: "")?.value?.trim()
                secondSupport?.let {
                    supports.addSupport(it, orders.secondSupport ?: emptyList())
                }
                val thirdSupport =
                    SUPPORT_TARGET_REGEX.find(orders.thirdSupportTarget ?: "")?.value?.trim()
                thirdSupport?.let {
                    supports.addSupport(it, orders.thirdSupport ?: emptyList())
                }

            }
        }.addRedirectCheck()


    override fun login(username: String, password: String): Completable =
        apiService.login(username, password, MEMORIZE_FORM_VALUE).addRedirectCheck().ignoreElement()

    private fun MutableList<AttackRemoteEntity>.addAttack(
        target: String,
        attackData: List<String>
    ) {
        add(
            AttackRemoteEntity(attackData.associate {
                Pair(
                    TroopType.fromValue(ATTACK_TROOP_TYPE_REGEX.find(it)?.value?.trim() ?: "")
                        ?: return,
                    ATTACK_TROOP_COUNT_REGEX.find(it)?.value?.trim()?.toInt() ?: 0
                )
            }, target)
        )
    }

    private fun MutableList<SupportRemoteEntity>.addSupport(
        target: String,
        supportData: List<String>
    ) {
        add(
            SupportRemoteEntity(supportData.associate {
                Pair(
                    TroopType.fromValue(SUPPORT_TROOP_TYPE_REGEX.find(it)?.value?.trim() ?: "")
                        ?: return,
                    SUPPORT_TROOP_COUNT_REGEX.find(it)?.value?.trim()?.toInt() ?: 0
                )
            }, target)
        )
    }

    private fun <T> Single<T>.addRedirectCheck(): Single<T> {
        return onErrorResumeNext {
            if (it is HttpException && it.code() == HTTP_REDIRECT_CODE) {
                Single.error(AuthenticationException())
            } else {
                Single.error(it)
            }
        }
    }
}