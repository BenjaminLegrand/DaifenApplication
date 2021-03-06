package fr.legrand.daifen.application.data.entity.mapper

import fr.legrand.daifen.application.data.entity.model.Pigeon
import fr.legrand.daifen.application.data.entity.remote.PigeonRemoteEntity
import fr.legrand.daifen.application.data.exception.MappingException
import java.text.SimpleDateFormat
import java.util.*

private const val REMOTE_DATE_FORMAT = "dd/MM/yy HH'h'mm"
private val REMOTE_ID_REGEX = Regex("(?<=id=)[0-9]+")

class PigeonRemoteEntityDataMapper(
    private val playerRemoteEntityDataMapper: PlayerRemoteEntityDataMapper
) {
    fun transform(remotes: List<PigeonRemoteEntity>): List<Pigeon> {
        return remotes.mapNotNull {
            try {
                transform(it)
            } catch (e: MappingException) {
                null
            }
        }
    }

    fun transform(remote: PigeonRemoteEntity): Pigeon {
        try {
            return Pigeon(
                REMOTE_ID_REGEX.find(remote.id)?.value?.toInt()
                    ?: remote.id.toInt(),
                playerRemoteEntityDataMapper.transform(remote.emitterPlayer),
                remote.receivers,
                remote.subject,
                SimpleDateFormat(REMOTE_DATE_FORMAT, Locale.getDefault()).parse(remote.date),
                remote.content,
                remote.history,
                remote.unread != null
            )
        } catch (e: Exception) {
            throw MappingException()
        }
    }
}