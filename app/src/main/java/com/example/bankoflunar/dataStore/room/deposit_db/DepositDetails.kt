package com.example.bankoflunar.dataStore.room.deposit_db

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DepositDetails (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val status: String,
    val amount: String,
    val account: String,
    val transactionId: String,
    val date: String,
    val modeOfPayment: String

)