package com.vplemyannik.cryptocurrencyappyt.data.api.dto

import com.google.gson.annotations.SerializedName
import com.vplemyannik.cryptocurrencyappyt.domain.model.Coin

data class CoinDto (
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

fun CoinDto.ToCoin(): Coin {
    return Coin(
        isActive = isActive,
        id = id,
        name = name,
        rank = rank,
        symbol = symbol
    )
}