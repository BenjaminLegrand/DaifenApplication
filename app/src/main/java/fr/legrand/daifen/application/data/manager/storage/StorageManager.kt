package fr.legrand.daifen.application.data.manager.storage

import fr.legrand.daifen.application.data.entity.db.PigeonDBEntity

interface StorageManager {
    fun getAllPigeons(): List<PigeonDBEntity>

    fun savePigeonList(pigeonList: List<PigeonDBEntity>)
    fun resetPigeonList()
}