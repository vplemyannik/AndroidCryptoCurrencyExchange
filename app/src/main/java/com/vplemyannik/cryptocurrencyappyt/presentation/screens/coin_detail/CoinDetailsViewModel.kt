package com.vplemyannik.cryptocurrencyappyt.presentation.screens.coin_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vplemyannik.cryptocurrencyappyt.common.Constants.COIN_ID
import com.vplemyannik.cryptocurrencyappyt.common.Resource
import com.vplemyannik.cryptocurrencyappyt.domain.use_cases.get_coin.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinDetailsViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(CoinDetailsState())
    val state: State<CoinDetailsState> = _state

    init {
        savedStateHandle.get<String>(COIN_ID)?.let { coinId ->
            getCoinDetailsById(coinId)
        }

    }


    private fun getCoinDetailsById(id: String) = viewModelScope.launch {
        getCoinUseCase(id).collect {
            when(it) {
                is Resource.Loading ->  {
                    _state.value = CoinDetailsState(loading = true)
                }
                is Resource.Success -> {
                    _state.value = CoinDetailsState(loading = false, data = it.data)
                }
                is Resource.Error -> {
                    _state.value = CoinDetailsState(loading = false, error = it.message ?: "Unexpected error occured")
                }
            }
        }
    }
}