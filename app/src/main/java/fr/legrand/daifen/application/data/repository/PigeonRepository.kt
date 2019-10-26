package fr.legrand.daifen.application.data.repository

import android.util.Log
import fr.legrand.daifen.application.data.entity.mapper.PigeonDBEntityDataMapper
import fr.legrand.daifen.application.data.entity.mapper.PigeonRemoteEntityDataMapper
import fr.legrand.daifen.application.data.entity.model.Pigeon
import fr.legrand.daifen.application.data.exception.AuthenticationException
import fr.legrand.daifen.application.data.exception.EmptyPigeonPageException
import fr.legrand.daifen.application.data.exception.PigeonAlreadyLoadedException
import fr.legrand.daifen.application.data.manager.api.ApiManager
import fr.legrand.daifen.application.data.manager.prefs.SharedPrefsManager
import fr.legrand.daifen.application.data.manager.storage.StorageManager
import io.reactivex.Completable
import io.reactivex.Single
import timber.log.Timber

private const val START_PIGEON_PAGE = 0
private const val PIGEON_LIMIT_PAGE = 500

class PigeonRepository(
    private val sharedPrefsManager: SharedPrefsManager,
    private val apiManager: ApiManager,
    private val storageManager: StorageManager,
    private val pigeonDBEntityDataMapper: PigeonDBEntityDataMapper,
    private val pigeonRemoteEntityDataMapper: PigeonRemoteEntityDataMapper
) {

    fun getLocalPigeonList(): Single<List<Pigeon>> = Single.defer {
        Log.i("TAG", "LOCAL")
        Single.just(pigeonDBEntityDataMapper.transformEntity(storageManager.getAllPigeons()))
    }

    fun getPigeonList(): Single<List<Pigeon>> = Single.defer {
        val currentPigeons =
            pigeonDBEntityDataMapper.transformEntity(storageManager.getAllPigeons())
        val pigeonList = mutableListOf<Pigeon>()
        Single.concat((START_PIGEON_PAGE..PIGEON_LIMIT_PAGE).map {
            getPigeonListForPage(it)
        }).doOnNext {
            //We keep only pigeons that are more recent
            it.forEach { pigeon ->
                if (pigeon.date.time > (currentPigeons.firstOrNull()?.date?.time ?: 0)) {
                    pigeonList.add(pigeon)
                } else {
                    throw PigeonAlreadyLoadedException()
                }
            }
        }.ignoreElements().onErrorResumeNext {
            if (it is EmptyPigeonPageException || it is PigeonAlreadyLoadedException) {
                Completable.complete()
            } else {
                Completable.error(it)
            }
        }.toSingle {
            storageManager.savePigeonList(pigeonDBEntityDataMapper.transformModel(pigeonList))
            pigeonList + currentPigeons
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

    fun getPigeon(id: Int): Single<Pigeon> = Single.defer {
        apiManager.getPigeon(id).map {
            storageManager.setPigeonRead(id)
            pigeonRemoteEntityDataMapper.transform(it)
        }.doOnError {
            Timber.e(it)
            if (it is AuthenticationException) sharedPrefsManager.resetAuthCookie()
        }

    }

    fun getPigeonUpdateAuthErrorReceived() = Single.defer {
        Single.just(sharedPrefsManager.getPigeonUpdateAuthErrorReceived())
    }

    fun onPigeonUpdateAuthErrorReceived() {
        sharedPrefsManager.onPigeonUpdateAuthErrorReceived()
    }
}