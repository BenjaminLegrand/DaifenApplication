package fr.legrand.daifen.application.data.entity.mapper

import fr.legrand.daifen.application.data.entity.model.Troop
import fr.legrand.daifen.application.data.entity.remote.TroopRemoteEntity
import fr.legrand.daifen.application.data.exception.MappingException
import fr.legrand.daifen.application.data.values.ReferentialValues

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
                troopType = remote.troopType,
                count = remote.count,
                attack = ReferentialValues.TROOP_REFERENTIAL[remote.troopType]?.attack ?: 0,
                defense = ReferentialValues.TROOP_REFERENTIAL[remote.troopType]?.defense ?: 0,
                resistance = ReferentialValues.TROOP_REFERENTIAL[remote.troopType]?.resistance ?: 0,
                gold = ReferentialValues.TROOP_REFERENTIAL[remote.troopType]?.gold ?: 0,
                intellect = ReferentialValues.TROOP_REFERENTIAL[remote.troopType]?.intellect ?: 0
            )
        } catch (e: Exception) {
            throw MappingException()
        }
    }
}