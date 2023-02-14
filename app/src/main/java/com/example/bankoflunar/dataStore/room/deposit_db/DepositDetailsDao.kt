package com.example.bankoflunar.dataStore.room.deposit_db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface DepositDetailsDao {
    @Query("SELECT * FROM depositDetails ORDER BY date ASC")
    fun getAll(): Flow<List<DepositDetails>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addDepositDetails(depositDetails: DepositDetails)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addAllDepositDetails(depositDetails: List<DepositDetails>)
}