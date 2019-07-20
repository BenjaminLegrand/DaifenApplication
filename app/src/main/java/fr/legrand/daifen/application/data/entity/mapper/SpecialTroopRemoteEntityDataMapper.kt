package fr.legrand.daifen.application.data.entity.mapper

import fr.legrand.daifen.application.data.entity.model.SpecialTroop
import fr.legrand.daifen.application.data.entity.remote.SpecialTroopRemoteEntity
import fr.legrand.daifen.application.data.exception.MappingException

class SpecialTroopRemoteEntityDataMapper {

    fun transform(remotes: List<SpecialTroopRemoteEntity>): List<SpecialTroop> {
        return remotes.mapNotNull {
            try {
                transform(it)
            } catch (e: MappingException) {
                null
            }
        }
    }

    fun transform(remote: SpecialTroopRemoteEntity): SpecialTroop {
        try {
            return SpecialTroop(
                remote.troopType,
                remote.specialTroopAction,
                remote.target,
                remote.showTarget
            )
        } catch (e: Exception) {
            throw MappingException()
        }
    }
}