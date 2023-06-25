package com.example.bankoflunar.data.model

import com.google.gson.annotations.SerializedName

data class Withdrawal(
    val accountType: String,
    val amount: String,
    val status: String,
    val id: String,
    val dateTime: String,
    val modeOfPayment: String,
)