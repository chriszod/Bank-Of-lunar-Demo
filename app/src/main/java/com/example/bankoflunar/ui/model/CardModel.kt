package com.example.bankoflunar.ui.model

data class Cards(
    val cardType: String,
    val cardSubtype: String,
    val amount: String,
    val interest: String,
    val interestUpdate: String,
    val duration: String,
    val capital: String,
    val buttonType: String,
)

object CardsGenerator {
    fun getCardData(size: Int) = List(size) {i ->
        Cards("ESOP",
            "Trading",
            "$1000",
            "0.5",
            "1 day",
            "20 Days",
            "YES",
            "Trade",)
    }
}