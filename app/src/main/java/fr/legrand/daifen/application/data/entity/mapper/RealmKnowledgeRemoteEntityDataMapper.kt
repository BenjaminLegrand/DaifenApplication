package fr.legrand.daifen.application.data.entity.mapper

import fr.legrand.daifen.application.data.entity.model.Knowledge
import fr.legrand.daifen.application.data.entity.remote.RealmKnowledgeRemoteEntity
import fr.legrand.daifen.application.data.exception.MappingException
import fr.legrand.daifen.application.data.values.KnowledgeType

class RealmKnowledgeRemoteEntityDataMapper {

    fun transform(remotes: List<RealmKnowledgeRemoteEntity>): List<Knowledge> {
        return remotes.mapNotNull {
            try {
                transform(it)
            } catch (e: MappingException) {
                null
            }
        }
    }

    fun transform(remote: RealmKnowledgeRemoteEntity): Knowledge {
        try {
            return Knowledge(
                KnowledgeType.fromValue(remote.knowledgeType) ?: throw MappingException(),
                remote.round.toInt()
            )
        } catch (e: Exception) {
            throw MappingException()
        }
    }
}