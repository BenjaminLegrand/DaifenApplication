package fr.legrand.daifen.application.data.manager.storage

import android.content.Context
import androidx.room.Room
import fr.legrand.daifen.application.data.entity.db.PigeonDBEntity

class StorageManagerImpl constructor(context: Context) : StorageManager {


    private val roomManager: RoomManager =
        Room.databaseBuilder(context, AppDatabase::class.java, "database").build().roomManager()

    override fun getAllPigeons(): List<PigeonDBEntity> = roomManager.getAllPigeons()

    override fun savePigeonList(pigeonList: List<PigeonDBEntity>) {
        roomManager.savePigeonList(pigeonList)
    }

    override fun resetPigeonList() {
       roomManager.clearPigeonList()
    }


}