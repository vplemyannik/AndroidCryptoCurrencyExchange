package com.plcoding.cryptocurrencyappyt.presentation.coin_detail

import com.plcoding.cryptocurrencyappyt.domain.model.Coin
import com.plcoding.cryptocurrencyappyt.domain.model.CoinDetails

data class CoinDetailsState(
    val loading: Boolean = false,
    val data: CoinDetails? = null,
    val error: String = ""
)
