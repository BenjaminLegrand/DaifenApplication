package fr.legrand.daifen.application.data.manager.api

import fr.legrand.daifen.application.data.entity.remote.*
import io.reactivex.Completable
import io.reactivex.Single

interface ApiManager {
    fun getPigeonList(page: Int): Single<List<PigeonRemoteEntity>>
    fun login(username: String, password: String): Completable
    fun checkUserInGame(): Single<Boolean>
    fun getPigeon(id: Int): Single<PigeonRemoteEntity>
    fun getRoundOrders(round: Int): Single<OrdersRemoteEntity>
    fun getCurrentRoundOrders(): Single<OrdersRemoteEntity>
    fun getRealm(): Single<RealmRemoteEntity>
    fun getFightList(): Single<List<FightListItemRemoteEntity>>
    fun getFight(round: Int, targetId : Int): Single<FightRemoteEntity>
}