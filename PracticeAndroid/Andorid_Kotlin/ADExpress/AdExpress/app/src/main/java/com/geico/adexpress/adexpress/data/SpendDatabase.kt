package com.geico.adexpress.adexpress.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Spend::class], version = 1)
@TypeConverters(DateConvertor::class)
abstract class SpendDatabase : RoomDatabase() {
    abstract fun getSpendDao(): SpendDao

    companion object {
        private const val DB_NAME = "Spends-Database.db"

        @Volatile
        private var instance: SpendDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            SpendDatabase::class.java,
            DB_NAME
        ).fallbackToDestructiveMigration().build()
    }
}