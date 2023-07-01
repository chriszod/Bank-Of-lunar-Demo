package com.example.bankoflunar.data.repository

import com.example.bankoflunar.Injectable
import com.example.bankoflunar.data.model.ForexTrading
import com.example.bankoflunar.data.model.StockCFDs
import com.example.bankoflunar.data.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ForexTradingRepository(
    private val apiService: ApiService,
): Injectable {
    suspend fun getForexTrading(): List<ForexTrading> = withContext(Dispatchers.IO) {
        apiService.getForexTrading().execute().body()
            ?: emptyList()
    }
}
