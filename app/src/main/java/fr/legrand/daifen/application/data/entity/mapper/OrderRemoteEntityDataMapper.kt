package fr.legrand.daifen.application.data.entity.mapper

import fr.legrand.daifen.application.data.entity.model.Knowledge
import fr.legrand.daifen.application.data.entity.model.Orders
import fr.legrand.daifen.application.data.entity.remote.OrdersRemoteEntity
import fr.legrand.daifen.application.data.exception.MappingException

class OrderRemoteEntityDataMapper(
    private val buildingRemoteEntityDataMapper: BuildingRemoteEntityDataMapper,
    private val troopRemoteEntityDataMapper: TroopRemoteEntityDataMapper,
    private val giftRemoteEntityDataMapper: GiftRemoteEntityDataMapper,
    private val specialTroopRemoteEntityDataMapper: SpecialTroopRemoteEntityDataMapper,
    private val attackRemoteEntityDataMapper: AttackRemoteEntityDataMapper,
    private val supportRemoteEntityDataMapper: SupportRemoteEntityDataMapper
) {

    fun transform(remote: OrdersRemoteEntity): Orders {
        try {
            return Orders(
                remote.round,
                remote.knowledge?.let { Knowledge(it, remote.round) },
                buildingRemoteEntityDataMapper.transform(remote.buildings),
                troopRemoteEntityDataMapper.transform(remote.troops),
                giftRemoteEntityDataMapper.transform(remote.gifts),
                specialTroopRemoteEntityDataMapper.transform(remote.specialTroops),
                attackRemoteEntityDataMapper.transform(remote.attacks),
                supportRemoteEntityDataMapper.transform(remote.supports)
            )
        } catch (e: Exception) {
            throw MappingException()
        }
    }
}