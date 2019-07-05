package fr.legrand.daifen.application.data.entity.mapper

import fr.legrand.daifen.application.data.entity.model.Pigeon
import fr.legrand.daifen.application.data.entity.remote.PigeonRemoteEntity
import fr.legrand.daifen.application.data.exception.MappingException
import java.text.SimpleDateFormat
import java.util.*

private const val REMOTE_DATE_FORMAT = "dd/MM/yy HH'h'mm"

class PigeonRemoteEntityDataMapper {
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
                    remote.emitter,
                    remote.subject,
                    SimpleDateFormat(REMOTE_DATE_FORMAT, Locale.getDefault()).parse(remote.date)
            )
        } catch (e: Exception) {
            throw MappingException()
        }
    }
}