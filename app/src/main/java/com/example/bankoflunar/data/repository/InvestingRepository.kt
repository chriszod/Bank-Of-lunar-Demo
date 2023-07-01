package com.example.bankoflunar.data.repository

import com.example.bankoflunar.Injectable
import com.example.bankoflunar.data.model.Deposit
import com.example.bankoflunar.data.model.Investing
import com.example.bankoflunar.data.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class InvestingRepository(
private val apiService: ApiService,
): Injectable {
    suspend fun getInvesting(): List<Investing> = withContext(Dispatchers.IO) {
        apiService.getInvesting().execute().body()
            ?: emptyList()
    }
}