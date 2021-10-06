package com.vplemyannik.cryptocurrencyappyt.presentation.screens.coin_detail

import com.vplemyannik.cryptocurrencyappyt.domain.model.CoinDetails

data class CoinDetailsState(
    val loading: Boolean = false,
    val data: CoinDetails? = null,
    val error: String = ""
)
