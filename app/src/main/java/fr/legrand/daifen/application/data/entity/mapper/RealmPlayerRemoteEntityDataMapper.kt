package fr.legrand.daifen.application.data.entity.mapper

import fr.legrand.daifen.application.data.entity.model.Player
import fr.legrand.daifen.application.data.entity.remote.RealmDiscoveredPlayerRemoteEntity
import fr.legrand.daifen.application.data.exception.MappingException
import fr.legrand.daifen.application.data.values.RaceType

class RealmPlayerRemoteEntityDataMapper {

    fun transform(remotes: List<RealmDiscoveredPlayerRemoteEntity>): List<Player> {
        return remotes.mapNotNull {
            try {
                transform(it)
            } catch (e: MappingException) {
                null
            }
        }
    }

    fun transform(remote: RealmDiscoveredPlayerRemoteEntity): Player {
        try {
            return Player(
                remote.name,
                RaceType.fromValue(remote.race) ?: throw MappingException(),
                remote.clan
            )
        } catch (e: Exception) {
            throw MappingException()
        }
    }
}