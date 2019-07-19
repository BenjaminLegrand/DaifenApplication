package fr.legrand.daifen.application.data.entity.mapper

import fr.legrand.daifen.application.data.entity.model.Gift
import fr.legrand.daifen.application.data.entity.remote.GiftRemoteEntity
import fr.legrand.daifen.application.data.exception.MappingException

class GiftRemoteEntityDataMapper {

    fun transform(remotes: List<GiftRemoteEntity>): List<Gift> {
        return remotes.mapNotNull {
            try {
                transform(it)
            } catch (e: MappingException) {
                null
            }
        }
    }

    fun transform(remote: GiftRemoteEntity): Gift {
        try {
            return Gift(
                remote.troopType,
                remote.target,
                remote.count
            )
        } catch (e: Exception) {
            throw MappingException()
        }
    }
}