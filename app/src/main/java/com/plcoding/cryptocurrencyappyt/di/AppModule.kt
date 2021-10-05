package com.plcoding.cryptocurrencyappyt.di

import com.plcoding.cryptocurrencyappyt.common.Constants
import com.plcoding.cryptocurrencyappyt.data.api.ICoinPaprikaApiClient
import com.plcoding.cryptocurrencyappyt.data.repository.CoinRemoteRepository
import com.plcoding.cryptocurrencyappyt.domain.repository.ICoinRepository
import com.plcoding.cryptocurrencyappyt.presentation.coin_list.CoinListViewModel
import com.plcoding.cryptocurrencyappyt.presentation.coin_list.ICoinListViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    companion object {
        @Provides
        @Singleton
        fun providePaprikaApiClient(): ICoinPaprikaApiClient  {
            return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ICoinPaprikaApiClient::class.java)
        }
    }


    @Binds
    abstract fun coinRepositoryBind(impl: CoinRemoteRepository): ICoinRepository
}