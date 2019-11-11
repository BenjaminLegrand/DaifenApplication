package fr.legrand.daifen.application.data.entity.mapper

import fr.legrand.daifen.application.data.entity.model.Fight
import fr.legrand.daifen.application.data.entity.remote.FightRemoteEntity
import fr.legrand.daifen.application.data.exception.MappingException
import fr.legrand.daifen.application.data.values.FightType

class FightRemoteEntityDataMapper {

    fun transform(remotes: List<FightRemoteEntity>): List<Fight> {
        return remotes.mapNotNull {
            try {
                transform(it)
            } catch (e: MappingException) {
                null
            }
        }
    }

    fun transform(remote: FightRemoteEntity): Fight {
        try {
            return Fight(
                remote.id,
                remote.type,
                //TODO
                emptyList(),
                emptyList(),
                emptyList(),
                emptyList(),
                emptyList(),
                emptyList(),
                emptyList()
            )
        } catch (e: Exception) {
            throw MappingException()
        }
    }
}