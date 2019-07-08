package fr.legrand.daifen.application.data.manager.api

import fr.legrand.daifen.application.BuildConfig
import fr.legrand.daifen.application.data.entity.remote.PigeonRemoteEntity
import fr.legrand.daifen.application.data.exception.AuthenticationException
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.HttpException


private const val HTTP_REDIRECT_CODE = 302
private const val MEMORIZE_FORM_VALUE = "on"

private const val PIGEON_DETAIL_DATE_REGEX = "le "
private const val PIGEON_DETAIL_CONVERSATION_LINE_SEPARATOR = "\n"
private const val PIGEON_DETAIL_CONVERSATION_START_SEPARATOR = '>'
private val PIGEON_DETAIL_CONVERSATION_START_REGEX = Regex(">+")
private val PIGEON_DETAIL_CONVERSATION_REGEX = Regex(">.*?\\s+(?=>)")
private val EMITTER_ID_REGEX = Regex("[0-9]+")

class ApiManagerImpl(private val apiService: ApiService) : ApiManager {

    override fun getPigeonList(page: Int): Single<List<PigeonRemoteEntity>> =
        apiService.getPigeonList(page).map {
            it.pigeonRemoteList
        }.onErrorResumeNext {
            return@onErrorResumeNext if (it is UninitializedPropertyAccessException) {
                Single.just(emptyList())
            } else {
                Single.error(it)
            }
        }.addRedirectCheck()

    override fun getPigeon(id: Int): Single<PigeonRemoteEntity> =
        apiService.getPigeon(id).map {
            val date = it.pigeonConversationData[1].substringAfterLast(PIGEON_DETAIL_DATE_REGEX)
            //The three first items are useless : links/emitter/receiver
            val data = it.pigeonConversationData.drop(3)

            val lastMessage =
                data.take(data.size - 1).joinToString(PIGEON_DETAIL_CONVERSATION_LINE_SEPARATOR)
            val historyMessages =
                PIGEON_DETAIL_CONVERSATION_REGEX.findAll(data.last()).map { it.value }
                    .toMutableList().asReversed()
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

    override fun login(username: String, password: String): Completable =
        apiService.login(username, password, MEMORIZE_FORM_VALUE).addRedirectCheck().ignoreElement()

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