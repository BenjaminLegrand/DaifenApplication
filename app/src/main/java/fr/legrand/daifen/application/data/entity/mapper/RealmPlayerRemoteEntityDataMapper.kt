package fr.legrand.daifen.application.data.entity.mapper

import fr.legrand.daifen.application.data.entity.model.RealmPlayer
import fr.legrand.daifen.application.data.entity.remote.RealmDiscoveredPlayerRemoteEntity
import fr.legrand.daifen.application.data.exception.MappingException
import fr.legrand.daifen.application.data.values.RaceType

class RealmPlayerRemoteEntityDataMapper {

    fun transform(remotes: List<RealmDiscoveredPlayerRemoteEntity>): List<RealmPlayer> {
        return remotes.mapNotNull {
            try {
                transform(it)
            } catch (e: MappingException) {
                null
            }
        }
    }

    fun transform(remote: RealmDiscoveredPlayerRemoteEntity): RealmPlayer {
        try {
            return RealmPlayer(
                remote.name,
                RaceType.fromValue(remote.race) ?: throw MappingException(),
                remote.clan
            )
        } catch (e: Exception) {
            throw MappingException()
        }
    }
}