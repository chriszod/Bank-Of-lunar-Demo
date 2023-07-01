package com.example.bankoflunar.data.repository

import com.example.bankoflunar.Injectable
import com.example.bankoflunar.data.model.Deposit
import com.example.bankoflunar.data.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DepositRepository(
    private val apiService: ApiService,
): Injectable {
    suspend fun getDeposits(): List<Deposit> = withContext(Dispatchers.IO) {
        apiService.getDeposits().execute().body()
            ?: emptyList()
    }
}