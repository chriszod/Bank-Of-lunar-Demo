package com.example.bankoflunar.data.network

import com.example.bankoflunar.data.model.Deposit
import com.example.bankoflunar.data.model.Withdrawal
import retrofit2.Call
import retrofit2.http.GET

const val BASE_URL = "http://192.168.0.128:8080"

interface ApiService {
    @GET("/deposits")
    fun getDeposits(): Call<List<Deposit>>

    @GET("/withdrawals")
    fun getWithdrawals(): Call<List<Withdrawal>>
}