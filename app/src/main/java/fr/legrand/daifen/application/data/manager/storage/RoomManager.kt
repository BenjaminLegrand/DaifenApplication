package fr.legrand.daifen.application.data.manager.storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import fr.legrand.daifen.application.data.entity.db.PigeonDBEntity

@Dao
interface RoomManager {
    @Query("SELECT * FROM pigeondbentity ORDER BY date DESC")
    fun getAllPigeons(): List<PigeonDBEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun savePigeonList(pigeonList: List<PigeonDBEntity>)

    @Query("DELETE FROM pigeondbentity")
    fun clearPigeonList()
}