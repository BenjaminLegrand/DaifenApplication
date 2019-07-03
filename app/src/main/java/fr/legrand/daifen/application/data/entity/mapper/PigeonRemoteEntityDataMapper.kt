package fr.legrand.daifen.application.data.entity.mapper

import fr.legrand.daifen.application.data.entity.model.Pigeon
import fr.legrand.daifen.application.data.entity.remote.PigeonRemoteEntity
import fr.legrand.daifen.application.data.exception.MappingException

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
                remote.subject
            )
        } catch (e: Exception) {
            throw MappingException()
        }
    }
}