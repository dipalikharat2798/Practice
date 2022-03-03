package com.androdevdk.designpattern

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import java.util.*

class Convertors1 {

    @TypeConverter
     fun fromDateToLong(value: Date): Long {
        return value.time
    }

    @TypeConverter
    fun fromLongToDate(value: Long): Date {
        return Date(value)
    }
}