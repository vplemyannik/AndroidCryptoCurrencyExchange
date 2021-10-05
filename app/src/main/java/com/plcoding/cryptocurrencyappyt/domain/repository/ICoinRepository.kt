package com.plcoding.cryptocurrencyappyt.domain.repository

import com.plcoding.cryptocurrencyappyt.domain.model.Coin
import com.plcoding.cryptocurrencyappyt.domain.model.CoinDetails

interface ICoinRepository {

    suspend fun getCoins(): List<Coin>
    suspend fun getCoinById(id: String): CoinDetails
}