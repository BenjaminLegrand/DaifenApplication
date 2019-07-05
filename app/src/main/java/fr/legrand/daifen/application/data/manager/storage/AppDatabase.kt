package fr.legrand.daifen.application.data.manager.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import fr.legrand.daifen.application.data.entity.db.PigeonDBEntity

@Database(version = 1, entities = [PigeonDBEntity::class], exportSchema = false)
@TypeConverters(RoomConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun roomManager(): RoomManager
}