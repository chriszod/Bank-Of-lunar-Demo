package com.example.bankoflunar.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface DepositDao {
    @Query("SELECT * FROM deposit ORDER BY date ASC")
    fun getAll(): Flow<List<Deposit>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addDepositDetails(deposit: Deposit)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addAllDepositDetails(depositDetails: List<Deposit>)
}