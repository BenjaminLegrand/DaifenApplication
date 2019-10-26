package fr.legrand.daifen.application.data.entity.mapper

import fr.legrand.daifen.application.data.entity.model.SpecialTroop
import fr.legrand.daifen.application.data.entity.model.Support
import fr.legrand.daifen.application.data.entity.remote.SupportRemoteEntity
import fr.legrand.daifen.application.data.exception.MappingException

class SupportRemoteEntityDataMapper {

    fun transform(remotes: List<SupportRemoteEntity>): List<Support> {
        return remotes.mapNotNull {
            try {
                transform(it)
            } catch (e: MappingException) {
                null
            }
        }
    }

    fun transform(remote: SupportRemoteEntity): Support {
        try {
            return Support(
                remote.troops,
                remote.target
            )
        } catch (e: Exception) {
            throw MappingException()
        }
    }
}