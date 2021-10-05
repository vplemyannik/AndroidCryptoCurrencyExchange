package com.vplemyannik.cryptocurrencyappyt.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vplemyannik.cryptocurrencyappyt.common.Resource
import com.vplemyannik.cryptocurrencyappyt.domain.use_cases.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

interface ICoinListViewModel {
    val state: State<CoinListState>
}


@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel(), ICoinListViewModel {

    private val _state = mutableStateOf(CoinListState())
    override val state: State<CoinListState> = _state

    init {
        getCoins()
    }

    private fun getCoins() = viewModelScope.launch {
        getCoinsUseCase().collect {
            when(it) {
                is Resource.Loading ->  {
                    _state.value = CoinListState(loading = true)
                }
                is Resource.Success -> {
                    _state.value = CoinListState(loading = false, data = it.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = CoinListState(loading = false, error = it.message ?: "Unexpected error occured")
                }
            }
        }
    }
}