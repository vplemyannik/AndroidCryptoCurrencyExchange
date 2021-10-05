package com.vplemyannik.cryptocurrencyappyt.data.api

import com.vplemyannik.cryptocurrencyappyt.data.api.dto.CoinDetailsDto
import com.vplemyannik.cryptocurrencyappyt.data.api.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ICoinPaprikaApiClient {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailsDto
}