package com.example.bankoflunar.dataStore.room.deposit_db

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DepositDetails::class], version = 1, exportSchema = false)

abstract class DepositDetailsRoomDatabase: RoomDatabase() {

    abstract fun depositDetailsDao(): DepositDetailsDao

    companion object {
        @Volatile
        private var INSTANCE: DepositDetailsRoomDatabase? = null
        fun getDatabase(context: Context): DepositDetailsRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DepositDetailsRoomDatabase::class.java, "depositDetails_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance

            }

        }

    }

}

class DepositApplication: Application(){
    val database: DepositDetailsRoomDatabase by lazy { DepositDetailsRoomDatabase.getDatabase(this) }
}