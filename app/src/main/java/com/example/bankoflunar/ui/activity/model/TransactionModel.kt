package com.example.bankoflunar.ui.activity.model

import com.example.bankoflunar.data.model.Deposit
import com.example.bankoflunar.data.model.Withdrawal
import java.time.LocalDateTime

data class TransactionModel(
    val accountType: String,
    val amount: String,
    val status: String,
    val id: String,
    val date: String,
    val time: String,
    val dateAndTime: String,
    val modeOfPayment: String,
)
fun Deposit.toTransactionModel(): TransactionModel =
    TransactionModel(
        accountType = accountType,
        id = id,
        amount = amount,
        dateAndTime = dateTime,
        modeOfPayment = modeOfPayment,
        date = dateTime,
        time = dateTime,
        status = status,
    )

fun Withdrawal.toTransactionModel(): TransactionModel =
    TransactionModel(
        accountType = accountType,
        id = id,
        amount = amount,
        dateAndTime = dateTime,
        modeOfPayment = modeOfPayment,
        date = dateTime,
        time = dateTime,
        status = status,
    )