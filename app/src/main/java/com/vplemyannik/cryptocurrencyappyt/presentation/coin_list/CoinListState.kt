package com.vplemyannik.cryptocurrencyappyt.presentation.coin_list

import com.vplemyannik.cryptocurrencyappyt.domain.model.Coin

data class CoinListState(
    val loading: Boolean = false,
    val data: List<Coin> = emptyList(),
    val error: String = ""
)
