package com.example.bankoflunar.data.repository

import com.example.bankoflunar.Injectable
import com.example.bankoflunar.data.model.RealEstate
import com.example.bankoflunar.data.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RealEstateRepository (
    private val apiService: ApiService,
    ): Injectable {
        suspend fun getRealEstate(): List<RealEstate> = withContext(Dispatchers.IO) {
            apiService.getRealEstate().execute().body()
                ?: emptyList()
        }
}