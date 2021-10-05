package com.vplemyannik.cryptocurrencyappyt.domain.use_cases.get_coins

import com.vplemyannik.cryptocurrencyappyt.common.Resource
import com.vplemyannik.cryptocurrencyappyt.domain.model.Coin
import com.vplemyannik.cryptocurrencyappyt.domain.repository.ICoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository : ICoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> {
        return flow {
            try {
                emit(Resource.Loading<List<Coin>>())
                val coins = repository.getCoins()
                emit(Resource.Success(coins))
            }
            catch (e: HttpException) {
                emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "Error occurred during fetch data"))
            }
            catch (e: IOException) {
                emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "Error occurred. Check internet connection"))
            }
        }
    }
}