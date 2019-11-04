package fr.legrand.daifen.application.data.entity.mapper

import fr.legrand.daifen.application.data.entity.model.Realm
import fr.legrand.daifen.application.data.entity.remote.RealmRemoteEntity
import fr.legrand.daifen.application.data.exception.MappingException

class RealmRemoteEntityDataMapper(
    private val realmBuildingRemoteEntityDataMapper: RealmBuildingRemoteEntityDataMapper,
    private val realmTroopRemoteEntityDataMapper: RealmTroopRemoteEntityDataMapper,
    private val realmKnowledgeRemoteEntityDataMapper: RealmKnowledgeRemoteEntityDataMapper,
    private val realmPlayerRemoteEntityDataMapper: RealmPlayerRemoteEntityDataMapper
) {


    fun transform(remote: RealmRemoteEntity): Realm {
        try {
            return Realm(
                remote.playerName,
                remote.playerImage,
                remote.rank,
                remote.points,
                remote.gold,
                remote.intellect,
                realmBuildingRemoteEntityDataMapper.transform(remote.buildings),
                realmTroopRemoteEntityDataMapper.transform(remote.troops),
                realmKnowledgeRemoteEntityDataMapper.transform(remote.knowledges),
                realmPlayerRemoteEntityDataMapper.transform(remote.discoveredPlayers)
            )
        } catch (e: Exception) {
            throw MappingException()
        }
    }
}