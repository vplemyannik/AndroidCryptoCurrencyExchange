package com.vplemyannik.cryptocurrencyappyt.domain.repository

import com.vplemyannik.cryptocurrencyappyt.domain.model.Coin
import com.vplemyannik.cryptocurrencyappyt.domain.model.CoinDetails

interface ICoinRepository {

    suspend fun getCoins(): List<Coin>
    suspend fun getCoinById(id: String): CoinDetails
}