package com.example.bankoflunar.data.model

data class Deposit(
    val accountType: String,
    val amount: String,
    val status: String,
    val id: String,
    val dateTime: String,
    val modeOfPayment: String,
)