package com.example.bankoflunar.ui.model

import com.example.bankoflunar.data.model.ForexTrading
import com.example.bankoflunar.data.model.Investing
import com.example.bankoflunar.data.model.RealEstate
import com.example.bankoflunar.data.model.StockCFDs

data class CardModel(
    val cardType: String,
    val cardSubtype: String,
    val amount: String,
    val interest: String,
    val interestUpdate: String,
    val duration: String,
    val capital: String,
    val buttonType: String,
)

fun Investing.toCardModel(): CardModel =
    CardModel(
        cardType = cardType,
        cardSubtype = cardSubtype,
        amount = amount,
        interest = interest,
        interestUpdate = interestUpdate,
        duration = duration,
        capital = capital,
        buttonType = buttonType,
    )

fun RealEstate.toCardModel(): CardModel =
    CardModel(
        cardType = cardType,
        cardSubtype = cardSubtype,
        amount = amount,
        interest = interest,
        interestUpdate = interestUpdate,
        duration = duration,
        capital = capital,
        buttonType = buttonType,
    )

fun StockCFDs.toCardModel(): CardModel =
    CardModel(
        cardType = cardType,
        cardSubtype = cardSubtype,
        amount = amount,
        interest = interest,
        interestUpdate = interestUpdate,
        duration = duration,
        capital = capital,
        buttonType = buttonType,
    )

fun ForexTrading.toCardModel(): CardModel =
    CardModel(
        cardType = cardType,
        cardSubtype = cardSubtype,
        amount = amount,
        interest = interest,
        interestUpdate = interestUpdate,
        duration = duration,
        capital = capital,
        buttonType = buttonType,
    )