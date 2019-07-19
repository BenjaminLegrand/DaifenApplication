package fr.legrand.daifen.application.data.repository

import fr.legrand.daifen.application.data.entity.mapper.OrderRemoteEntityDataMapper
import fr.legrand.daifen.application.data.entity.model.Orders
import fr.legrand.daifen.application.data.manager.api.ApiManager
import io.reactivex.Single

class OrdersRepository(
    private val apiManager: ApiManager,
    private val orderRemoteEntityDataMapper: OrderRemoteEntityDataMapper
    ) {

    fun getCurrentRoundOrders(): Single<Orders> =
        apiManager.getCurrentRoundOrders().map {
            orderRemoteEntityDataMapper.transform(it)
        }
}