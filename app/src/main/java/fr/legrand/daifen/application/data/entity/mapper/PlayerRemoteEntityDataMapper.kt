package fr.legrand.daifen.application.data.entity.mapper

import fr.legrand.daifen.application.data.entity.model.Player
import fr.legrand.daifen.application.data.entity.remote.PlayerRemoteEntity
import fr.legrand.daifen.application.data.exception.MappingException

class PlayerRemoteEntityDataMapper {

    fun transform(remotes: List<PlayerRemoteEntity>): List<Player> {
        return remotes.mapNotNull {
            try {
                transform(it)
            } catch (e: MappingException) {
                null
            }
        }
    }

    fun transform(remote: PlayerRemoteEntity): Player {
        try {
            return Player(
                remote.id,
                remote.name,
                remote.image
            )
        } catch (e: Exception) {
            throw MappingException()
        }
    }
}