package com.vplemyannik.cryptocurrencyappyt.presentation


sealed class NavigationRoute(val rout: String) {
    object CoinsList: NavigationRoute("coins")
    object CoinDetails: NavigationRoute("coin-details")
}