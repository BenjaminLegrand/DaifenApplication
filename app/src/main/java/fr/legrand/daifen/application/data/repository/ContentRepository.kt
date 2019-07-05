package fr.legrand.daifen.application.data.repository

import fr.legrand.daifen.application.data.entity.mapper.PigeonDBEntityDataMapper
import fr.legrand.daifen.application.data.entity.mapper.PigeonRemoteEntityDataMapper
import fr.legrand.daifen.application.data.entity.model.Pigeon
import fr.legrand.daifen.application.data.exception.AuthenticationException
import fr.legrand.daifen.application.data.exception.EmptyPigeonPageException
import fr.legrand.daifen.application.data.manager.api.ApiManager
import fr.legrand.daifen.application.data.manager.prefs.SharedPrefsManager
import fr.legrand.daifen.application.data.manager.storage.StorageManager
import io.reactivex.Completable
import io.reactivex.Single
import timber.log.Timber

private const val START_PIGEON_PAGE = 0
private const val PIGEON_LIMIT_PAGE = 500

class ContentRepository(
    private val sharedPrefsManager: SharedPrefsManager,
    private val apiManager: ApiManager,
    private val storageManager: StorageManager,
    private val pigeonDBEntityDataMapper: PigeonDBEntityDataMapper,
    private val pigeonRemoteEntityDataMapper: PigeonRemoteEntityDataMapper
) {
    fun getPigeonList(): Single<List<Pigeon>> = Single.defer {
        val pigeonList = mutableListOf<Pigeon>()
        Single.concat((START_PIGEON_PAGE..PIGEON_LIMIT_PAGE).map {
            getPigeonListForPage(it)
        }).doOnNext {
            pigeonList.addAll(it)
        }.ignoreElements().onErrorResumeNext {
            if (it is EmptyPigeonPageException) {
                Completable.complete()
            } else {
                Completable.error(it)
            }
        }.toSingle {
            val currentPigeons =
                pigeonDBEntityDataMapper.transformEntity(storageManager.getAllPigeons())
            //TODO do this with scraping
            pigeonList.forEach { if (it !in currentPigeons) it.unread = true }
            storageManager.savePigeonList(pigeonDBEntityDataMapper.transformModel(pigeonList))
            pigeonList
        }
    }

    private fun getPigeonListForPage(page: Int): Single<List<Pigeon>> =
        apiManager.getPigeonList(page).map {
            if (it.isEmpty()) {
                throw EmptyPigeonPageException()
            }
            pigeonRemoteEntityDataMapper.transform(it)
        }.doOnError {
            Timber.e(it)
            if (it is AuthenticationException) sharedPrefsManager.resetAuthCookie()
        }
}