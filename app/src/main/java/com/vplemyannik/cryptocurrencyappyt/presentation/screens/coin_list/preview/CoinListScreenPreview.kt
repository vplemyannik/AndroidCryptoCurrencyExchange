package com.vplemyannik.cryptocurrencyappyt.presentation.screens.coin_list.preview

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.vplemyannik.cryptocurrencyappyt.domain.model.Coin
import com.vplemyannik.cryptocurrencyappyt.presentation.screens.coin_list.CoinListScreen
import com.vplemyannik.cryptocurrencyappyt.presentation.screens.coin_list.CoinListState
import com.vplemyannik.cryptocurrencyappyt.presentation.screens.coin_list.ICoinListViewModel


class FakeCoinListModel : ICoinListViewModel {
    override val state: State<CoinListState> get() = mutableStateOf(
        CoinListState(data = listOf(
            Coin("bitcoin", true, "bitcoin", 1, "BTS"),
            Coin("bitcoin1", true, "bitcoin1", 2, "BTS1"),
            Coin("bitcoin2", true, "bitcoin2", 3, "BTS2"),
            )
        )
    )
}

@Preview(name = "previewList", showBackground = true, showSystemUi = true)
@Composable
fun CoinListScreenPreview(
) {
    val navController = rememberNavController()
   CoinListScreen(navController, FakeCoinListModel())
}


class FakeCoinListErrorModel : ICoinListViewModel {
    override val state: State<CoinListState> get() = mutableStateOf(
        CoinListState(error = "Network issue occured")
    )
}

@Preview(name = "previewListError", showBackground = true, showSystemUi = true)
@Composable
fun CoinListErrorScreenPreview(
) {
    val navController = rememberNavController()
    CoinListScreen(navController, FakeCoinListErrorModel())
}

class FakeCoinListLoadingModel : ICoinListViewModel {
    override val state: State<CoinListState> get() = mutableStateOf(
        CoinListState(loading = true)
    )
}

@Preview(name = "previewListLoading", showBackground = true, showSystemUi = true)
@Composable
fun CoinListLoadingScreenPreview(
) {
    val navController = rememberNavController()
    CoinListScreen(navController, FakeCoinListLoadingModel())
}