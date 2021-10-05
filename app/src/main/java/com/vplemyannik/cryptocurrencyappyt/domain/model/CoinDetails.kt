package com.vplemyannik.cryptocurrencyappyt.domain.model

import com.vplemyannik.cryptocurrencyappyt.data.api.dto.CoinDetailsDto

class CoinDetails (
    val id: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<CoinDetailsDto.TeamMember>
)