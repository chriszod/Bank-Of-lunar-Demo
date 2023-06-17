package com.example.bankoflunar.ui.activity.model

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import kotlin.random.Random

data class Activity(
    val accountType: String,
    val amount: String,
    val status: String,
    val id: String,
    val date: String,
    val time: String,
    val dateAndTime: String,
    val modeOfPayment: String,
)

object ActivityGenerator {
    fun getActivityData(size: Int) = List(size) { i ->
        Activity(
            accountType = if(Random.nextInt() % 4 == 3) "PERSONAL" else "SAVINGS",
            amount = (i * 100).toString(),
            status = "PENDING",
            id = Random.nextInt(100_000, 999_999).toString(),
            date = LocalDate.now().toString(),
            time = LocalTime.now().toString(),
            dateAndTime = LocalDateTime.now().toString(),
            modeOfPayment = if(i % 2 == 0) "BTC" else "USDT",
        )
    }
}