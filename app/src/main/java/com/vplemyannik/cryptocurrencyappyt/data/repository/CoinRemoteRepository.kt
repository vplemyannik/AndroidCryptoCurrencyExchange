package com.vplemyannik.cryptocurrencyappyt.data.repository

import com.vplemyannik.cryptocurrencyappyt.data.api.ICoinPaprikaApiClient
import com.vplemyannik.cryptocurrencyappyt.data.api.dto.ToCoin
import com.vplemyannik.cryptocurrencyappyt.data.api.dto.ToCoinDetails
import com.vplemyannik.cryptocurrencyappyt.domain.model.Coin
import com.vplemyannik.cryptocurrencyappyt.domain.model.CoinDetails
import com.vplemyannik.cryptocurrencyappyt.domain.repository.ICoinRepository
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