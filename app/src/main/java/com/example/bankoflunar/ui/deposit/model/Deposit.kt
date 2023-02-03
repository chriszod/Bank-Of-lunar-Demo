package com.example.bankoflunar.ui.deposit.model

data class Deposit(
    val accountType: String,
    val amount: String,
    val status: String,
    val id: String,
    val date: String,
    val time: String,
    val modeOfPayment: String,
)