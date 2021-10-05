package com.vplemyannik.cryptocurrencyappyt.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.vplemyannik.cryptocurrencyappyt.common.Constants
import com.vplemyannik.cryptocurrencyappyt.common.Constants.COIN_ID
import com.vplemyannik.cryptocurrencyappyt.presentation.coin_detail.CoinDetailScreen
import com.vplemyannik.cryptocurrencyappyt.presentation.coin_list.CoinListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptocurrencyAppYTTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = NavigationRoute.CoinsList.rout) {
                        composable(route = NavigationRoute.CoinsList.rout) {
                            CoinListScreen(navController)
                        }
                        composable(
                            route = NavigationRoute.CoinDetails.rout + "/{$COIN_ID}",
                            arguments = listOf(navArgument(Constants.COIN_ID) { type = NavType.StringType })) {
                            CoinDetailScreen()
                        }
                    }
                }
            }
        }
    }
}