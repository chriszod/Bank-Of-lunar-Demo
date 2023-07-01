package com.example.bankoflunar.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Deposit(
    @PrimaryKey
    val id: Int,
    val accountType: String,
    val amount: String,
    val status: String,
    val date: String,
    val time: String,
    val dateTime: String,
    val modeOfPayment: String,
)
