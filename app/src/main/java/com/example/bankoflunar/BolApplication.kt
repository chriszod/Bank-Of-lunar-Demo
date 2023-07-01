package com.example.bankoflunar

import android.app.Application
import com.example.bankoflunar.data.network.ApiService
import com.example.bankoflunar.data.network.BASE_URL
import com.example.bankoflunar.data.repository.DepositRepository
import com.example.bankoflunar.data.repository.ForexTradingRepository
import com.example.bankoflunar.data.repository.InvestingRepository
import com.example.bankoflunar.data.repository.RealEstateRepository
import com.example.bankoflunar.data.repository.StockCFDsRepository
import com.example.bankoflunar.data.repository.WithdrawalRepository
import com.example.bankoflunar.data.room.BolRoomDatabase
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.reflect.KClass

interface Injectable

class BolApplication : Application() {
    private val database: BolRoomDatabase by lazy { BolRoomDatabase.getDatabase(this) }

    private val apiService: ApiService by lazy {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiService::class.java)
    }

    fun depositRepository() = DepositRepository(apiService = apiService)
    fun withdrawalRepository() = WithdrawalRepository(apiService = apiService)
    fun investingRepository() = InvestingRepository(apiService = apiService)
    fun realEstateRepository() = RealEstateRepository(apiService = apiService)
    fun stockCFDsRepository() = StockCFDsRepository(apiService = apiService)
    fun forexTradingRepository() = ForexTradingRepository(apiService = apiService)

    @Suppress("UNCHECKED_CAST")
    fun <I : Injectable> getInjectable(injectable: KClass<I>): I = when (injectable) {
        DepositRepository::class -> depositRepository()
        WithdrawalRepository::class -> withdrawalRepository()
        InvestingRepository::class -> investingRepository()
        RealEstateRepository::class -> realEstateRepository()
        StockCFDsRepository::class -> stockCFDsRepository()
        ForexTradingRepository::class -> forexTradingRepository()
        else -> throw IllegalArgumentException("Injectable not found")
    } as I
}