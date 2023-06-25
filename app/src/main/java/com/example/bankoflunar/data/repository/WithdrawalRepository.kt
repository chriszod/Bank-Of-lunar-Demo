package com.example.bankoflunar.data.repository

import com.example.bankoflunar.Injectable
import com.example.bankoflunar.data.model.Deposit
import com.example.bankoflunar.data.model.Withdrawal
import com.example.bankoflunar.data.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WithdrawalRepository(
    private val apiService: ApiService,
): Injectable {
    suspend fun getWithdrawals(): List<Withdrawal> = withContext(Dispatchers.IO) {
        apiService.getWithdrawals().execute().body()
            ?: emptyList()
    }
}