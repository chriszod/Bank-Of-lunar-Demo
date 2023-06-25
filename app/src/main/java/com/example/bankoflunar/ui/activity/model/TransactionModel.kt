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
fun Deposit.toTransactionModel(): TransactionModel {
//    val localDateTime = LocalDateTime.parse(dateTime)
    return TransactionModel(
        accountType = accountType,
        id = id,
        amount = amount,
        dateAndTime = dateTime,
        modeOfPayment = modeOfPayment,
        date = dateTime, //localDateTime.toLocalDate().toString(),
        time = dateTime, //localDateTime.toLocalTime().toString(),
        status = status,
    )
}

fun Withdrawal.toTransactionModel(): TransactionModel {
//    val localDateTime = LocalDateTime.parse(dateTime)
    return TransactionModel(
        accountType = accountType,
        id = id,
        amount = amount,
        dateAndTime = dateTime,
        modeOfPayment = modeOfPayment,
        date = dateTime, //localDateTime.toLocalDate().toString(),
        time = dateTime, //localDateTime.toLocalTime().toString(),
        status = status,
    )
}