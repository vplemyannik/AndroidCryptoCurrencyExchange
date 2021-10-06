package com.vplemyannik.cryptocurrencyappyt.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.vplemyannik.cryptocurrencyappyt.common.Constants
import com.vplemyannik.cryptocurrencyappyt.common.Constants.COIN_ID
import com.vplemyannik.cryptocurrencyappyt.presentation.screens.coin_detail.CoinDetailScreen
import com.vplemyannik.cryptocurrencyappyt.presentation.screens.coin_list.CoinListScreen
import com.vplemyannik.cryptocurrencyappyt.presentation.screens.components.CryptoCurrencyAppBar
import com.vplemyannik.cryptocurrencyappyt.presentation.theme.Theme
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var isDarkTheme by remember {
                mutableStateOf(true)
            }
            Theme(darkTheme = isDarkTheme) {
                Surface(color = MaterialTheme.colors.background) {
                    CryptoCurrencyAppBar(
                        isDarkTheme = isDarkTheme,
                        onChangeThemeClick = { value -> isDarkTheme = value })
                    {
                        val navController = rememberNavController()
                        NavHost(navController = navController, startDestination = NavigationRoute.CoinsList.rout) {
                            composable(route = NavigationRoute.CoinsList.rout) {
                                CoinListScreen(navController)
                            }
                            composable(
                                route = NavigationRoute.CoinDetails.rout + "/{$COIN_ID}",
                                arguments = listOf(navArgument(Constants.COIN_ID) { type = NavType.StringType })
                            ) {
                                CoinDetailScreen()
                            }
                        }
                    }
                }
            }
        }
    }
}