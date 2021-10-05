package com.vplemyannik.cryptocurrencyappyt.domain.use_cases.get_coin

import com.vplemyannik.cryptocurrencyappyt.common.Resource
import com.vplemyannik.cryptocurrencyappyt.domain.model.CoinDetails
import com.vplemyannik.cryptocurrencyappyt.domain.repository.ICoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
   private val repository : ICoinRepository
) {
    operator fun invoke(id: String): Flow<Resource<CoinDetails>> {
        return flow {
            try {
                emit(Resource.Loading<CoinDetails>())
                val coin = repository.getCoinById(id)
                emit(Resource.Success(coin))
            }
            catch (e: HttpException) {
                emit(Resource.Error<CoinDetails>(e.localizedMessage ?: "Error occurred during fetch data"))
            }
            catch (e: IOException) {
                emit(Resource.Error<CoinDetails>(e.localizedMessage ?: "Error occurred. Check internet connection"))
            }
        }
    }
}