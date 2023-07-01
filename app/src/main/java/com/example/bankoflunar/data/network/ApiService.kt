package com.example.bankoflunar.data.network


import com.example.bankoflunar.data.model.Deposit
import com.example.bankoflunar.data.model.ForexTrading
import com.example.bankoflunar.data.model.Investing
import com.example.bankoflunar.data.model.RealEstate
import com.example.bankoflunar.data.model.StockCFDs
import com.example.bankoflunar.data.model.Withdrawal
import retrofit2.http.GET

const val BASE_URL = "http://192.168.14.103:8080"

interface ApiService {
    @GET("/deposits")
    fun getDeposits(): retrofit2.Call<List<Deposit>>

    @GET("/withdrawals")
    fun getWithdrawals(): retrofit2.Call<List<Withdrawal>>

    @GET("/investing")
    fun getInvesting(): retrofit2.Call<List<Investing>>

    @GET("/realEstate")
    fun getRealEstate(): retrofit2.Call<List<RealEstate>>

    @GET("/stockCFDs")
    fun getStockCFDs(): retrofit2.Call<List<StockCFDs>>

    @GET("/forexTrading")
    fun getForexTrading(): retrofit2.Call<List<ForexTrading>>

}