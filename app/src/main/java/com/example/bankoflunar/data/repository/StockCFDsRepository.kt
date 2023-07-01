package com.example.bankoflunar.data.repository

import com.example.bankoflunar.Injectable
import com.example.bankoflunar.data.model.Deposit
import com.example.bankoflunar.data.model.StockCFDs
import com.example.bankoflunar.data.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class StockCFDsRepository(
    private val apiService: ApiService,
): Injectable {
    suspend fun getStockCFDs(): List<StockCFDs> = withContext(Dispatchers.IO) {
        apiService.getStockCFDs().execute().body()
            ?: emptyList()
    }
}