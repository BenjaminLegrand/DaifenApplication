package fr.legrand.daifen.application.data.entity.mapper

import fr.legrand.daifen.application.data.entity.model.Attack
import fr.legrand.daifen.application.data.entity.remote.AttackRemoteEntity
import fr.legrand.daifen.application.data.exception.MappingException

class AttackRemoteEntityDataMapper {

    fun transform(remotes: List<AttackRemoteEntity>): List<Attack> {
        return remotes.mapNotNull {
            try {
                transform(it)
            } catch (e: MappingException) {
                null
            }
        }
    }

    fun transform(remote: AttackRemoteEntity): Attack {
        try {
            return Attack(
                remote.troops,
                remote.target
            )
        } catch (e: Exception) {
            throw MappingException()
        }
    }
}