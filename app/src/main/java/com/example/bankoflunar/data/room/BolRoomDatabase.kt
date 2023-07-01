package com.example.bankoflunar.data.room

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Deposit::class], version = 1, exportSchema = false)
abstract class BolRoomDatabase: RoomDatabase() {

    abstract fun depositDetailsDao(): DepositDao

    companion object {
        @Volatile
        private var INSTANCE: BolRoomDatabase? = null

        fun getDatabase(context: Context): BolRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BolRoomDatabase::class.java, "BOLRoomdatabase"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}