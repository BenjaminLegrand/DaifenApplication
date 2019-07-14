package fr.legrand.daifen.application.data.manager.storage

import androidx.room.TypeConverter
import com.google.gson.Gson
import fr.legrand.daifen.application.data.utils.fromJson
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

    @TypeConverter
    fun stringListfromString(value: String): List<String> {
        return Gson().fromJson(value)
    }

    @TypeConverter
    fun stringListToString(value: List<String>): String {
        return Gson().toJson(value)
    }
}
