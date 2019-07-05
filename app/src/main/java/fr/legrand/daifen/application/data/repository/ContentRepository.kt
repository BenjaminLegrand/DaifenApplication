package fr.legrand.daifen.application.data.repository

import fr.legrand.daifen.application.data.entity.mapper.PigeonRemoteEntityDataMapper
import fr.legrand.daifen.application.data.entity.model.Pigeon
import fr.legrand.daifen.application.data.exception.AuthenticationException
import fr.legrand.daifen.application.data.exception.EmptyPigeonPageException
import fr.legrand.daifen.application.data.manager.api.ApiManager
import fr.legrand.daifen.application.data.manager.prefs.SharedPrefsManager
import io.reactivex.Completable
import io.reactivex.Single

private const val START_PIGEON_PAGE = 0
private const val PIGEON_LIMIT_PAGE = 500

class ContentRepository(
        private val sharedPrefsManager: SharedPrefsManager,
        private val apiManager: ApiManager,
        private val pigeonRemoteEntityDataMapper: PigeonRemoteEntityDataMapper
) {
    fun getPigeonList(): Single<List<Pigeon>> = Single.defer {
        val pigeonList = mutableListOf<Pigeon>()
        Single.concat((START_PIGEON_PAGE..PIGEON_LIMIT_PAGE).map {
            getPigeonListForPage(it)
        }).doOnNext { pigeonList.addAll(it) }.ignoreElements().onErrorResumeNext {
            if (it is EmptyPigeonPageException) {
                Completable.complete()
            } else {
                Completable.error(it)
            }
        }.toSingle { pigeonList }
    }

    private fun getPigeonListForPage(page: Int): Single<List<Pigeon>> =
            apiManager.getPigeonList(page).map {
                if (it.isEmpty()) {
                    throw EmptyPigeonPageException()
                }
                pigeonRemoteEntityDataMapper.transform(it)
            }.doOnError { if (it is AuthenticationException) sharedPrefsManager.resetAuthCookie() }
}