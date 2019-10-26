package fr.legrand.daifen.application.data.entity.mapper

import fr.legrand.daifen.application.data.entity.model.Troop
import fr.legrand.daifen.application.data.entity.remote.RealmTroopRemoteEntity
import fr.legrand.daifen.application.data.exception.MappingException
import fr.legrand.daifen.application.data.values.TroopType

class RealmTroopRemoteEntityDataMapper {

    fun transform(remotes: List<RealmTroopRemoteEntity>): List<Troop> {
        return remotes.mapNotNull {
            try {
                transform(it)
            } catch (e: MappingException) {
                null
            }
        }
    }

    fun transform(remote: RealmTroopRemoteEntity): Troop {
        try {
            return Troop(
                TroopType.fromValue(remote.troopType) ?: throw MappingException(),
                remote.count.toInt(),
                remote.attack.toInt(),
                remote.defense.toInt(),
                remote.resistance.toInt(),
                remote.gold.toInt(),
                remote.intellect.toInt()
            )
        } catch (e: Exception) {
            throw MappingException()
        }
    }
}