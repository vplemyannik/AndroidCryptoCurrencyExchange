package com.vplemyannik.cryptocurrencyappyt.presentation.screens.components

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable

@Composable
fun CryptoCurrencyAppBar (
    isDarkTheme: Boolean,
    onChangeThemeClick: (isDarkTheme: Boolean) -> Unit,
    content: @Composable () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "AppBar")
                },
                actions= {
                    IconToggleButton(onCheckedChange = {
                        onChangeThemeClick(it)
                    }, checked = isDarkTheme) {
                        Icon(Icons.Filled.Settings, contentDescription = "Change theme")
                    }
                }
            )
        },
    ) {
        content()
    }
}