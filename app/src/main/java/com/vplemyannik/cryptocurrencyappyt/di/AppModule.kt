package com.vplemyannik.cryptocurrencyappyt.di

import com.vplemyannik.cryptocurrencyappyt.common.Constants
import com.vplemyannik.cryptocurrencyappyt.data.api.ICoinPaprikaApiClient
import com.vplemyannik.cryptocurrencyappyt.data.repository.CoinRemoteRepository
import com.vplemyannik.cryptocurrencyappyt.domain.repository.ICoinRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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