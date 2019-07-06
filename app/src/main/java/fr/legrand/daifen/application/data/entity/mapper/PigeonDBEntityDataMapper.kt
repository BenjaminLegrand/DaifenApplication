package fr.legrand.daifen.application.data.entity.mapper

import fr.legrand.daifen.application.data.entity.db.PigeonDBEntity
import fr.legrand.daifen.application.data.entity.model.Pigeon
import fr.legrand.daifen.application.data.exception.MappingException

class PigeonDBEntityDataMapper {
    fun transformEntity(remotes: List<PigeonDBEntity>): List<Pigeon> {
        return remotes.mapNotNull {
            try {
                transform(it)
            } catch (e: MappingException) {
                null
            }
        }
    }

    fun transformModel(models: List<Pigeon>): List<PigeonDBEntity> {
        return models.mapNotNull {
            try {
                transform(it)
            } catch (e: MappingException) {
                null
            }
        }
    }

    fun transform(model: Pigeon): PigeonDBEntity {
        try {
            return PigeonDBEntity(
                model.id,
                model.emitter,
                model.subject,
                model.date
            )
        } catch (e: Exception) {
            throw MappingException()
        }
    }

    fun transform(db: PigeonDBEntity): Pigeon {
        try {
            return Pigeon(
                db.id,
                db.emitter,
                db.subject,
                db.date
            )
        } catch (e: Exception) {
            throw MappingException()
        }
    }
}