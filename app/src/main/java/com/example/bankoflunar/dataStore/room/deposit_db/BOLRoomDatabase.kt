package com.example.bankoflunar.dataStore.room.deposit_db

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DepositDetails::class], version = 1, exportSchema = false)

abstract class BOLRoomDatabase: RoomDatabase() {

    abstract fun depositDetailsDao(): DepositDetailsDao

    companion object {
        @Volatile
        private var INSTANCE: BOLRoomDatabase? = null
        fun getDatabase(context: Context): BOLRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BOLRoomDatabase::class.java, "BOLRoomdatabase"
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
    val database: BOLRoomDatabase by lazy { BOLRoomDatabase.getDatabase(this) }
}