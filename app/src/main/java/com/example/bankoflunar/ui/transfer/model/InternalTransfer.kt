package com.example.bankoflunar.ui.transfer.model

import java.time.Instant
import kotlin.random.Random

data class InternalTransfer(
    val accountType: String,
    val amount: String,
    val status: String,
    val id: String,
    val date: String,
    val time: String,
    val modeOfPayment: String,
)

object InternalTransferGenerator {
    fun getInternalTransfersData(size: Int) = List(size) { i ->
        InternalTransfer(
            accountType = if(Random.nextInt() % 4 == 3) "PERSONAL" else "SAVINGS",
            amount = (i * 100).toString(),
            status = "PENDING",
            id = Random.nextInt(100_000, 999_999).toString(),
            date = Instant.now().toString(),
            time = "0:${(i*10)%60}",
            modeOfPayment = if(i % 2 == 0) "BTC" else "USDT",
        )
    }
}