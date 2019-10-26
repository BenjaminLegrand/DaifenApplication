package fr.legrand.daifen.application.data.entity.mapper

import fr.legrand.daifen.application.data.entity.model.Troop
import fr.legrand.daifen.application.data.entity.remote.TroopRemoteEntity
import fr.legrand.daifen.application.data.exception.MappingException

class TroopRemoteEntityDataMapper {

    fun transform(remotes: List<TroopRemoteEntity>): List<Troop> {
        return remotes.mapNotNull {
            try {
                transform(it)
            } catch (e: MappingException) {
                null
            }
        }
    }

    fun transform(remote: TroopRemoteEntity): Troop {
        try {
            return Troop(
                remote.troopType,
                remote.count
            )
        } catch (e: Exception) {
            throw MappingException()
        }
    }
}