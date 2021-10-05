package com.plcoding.cryptocurrencyappyt.data.repository

import com.plcoding.cryptocurrencyappyt.data.api.ICoinPaprikaApiClient
import com.plcoding.cryptocurrencyappyt.data.api.dto.ToCoin
import com.plcoding.cryptocurrencyappyt.data.api.dto.ToCoinDetails
import com.plcoding.cryptocurrencyappyt.domain.model.Coin
import com.plcoding.cryptocurrencyappyt.domain.model.CoinDetails
import com.plcoding.cryptocurrencyappyt.domain.repository.ICoinRepository
import javax.inject.Inject

class CoinRemoteRepository @Inject constructor(
    private val apiClient: ICoinPaprikaApiClient
): ICoinRepository {

    override suspend fun getCoins(): List<Coin> {
         return apiClient.getCoins().map { it.ToCoin() }
    }

    override suspend fun getCoinById(id: String): CoinDetails {
        return apiClient.getCoinById(id).ToCoinDetails()
    }
}