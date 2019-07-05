package fr.legrand.daifen.application.data.manager.storage

import androidx.room.TypeConverter
import java.util.*

class RoomConverters {
    @TypeConverter
    fun fromTimestamp(value: Long): Date {
        return Date(value)
    }

    @TypeConverter
    fun dateToTimestamp(date: Date): Long {
        return date.time
    }
}
