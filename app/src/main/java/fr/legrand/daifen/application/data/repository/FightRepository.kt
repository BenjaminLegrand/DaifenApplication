package fr.legrand.daifen.application.data.repository

import fr.legrand.daifen.application.data.entity.model.Fight
import io.reactivex.Single

class FightRepository {
    fun retrieveFightList(): Single<List<Fight>> {
        return Single.just(listOf())
    }
}