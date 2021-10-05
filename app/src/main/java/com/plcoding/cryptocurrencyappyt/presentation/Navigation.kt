package com.plcoding.cryptocurrencyappyt.presentation


sealed class NavigationRoute(val rout: String) {
    object CoinsList: NavigationRoute("coins")
    object CoinDetails: NavigationRoute("coin-details")
}