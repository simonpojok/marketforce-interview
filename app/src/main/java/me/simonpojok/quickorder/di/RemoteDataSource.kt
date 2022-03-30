package me.simonpojok.quickorder.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.simonpojok.remote.RemoteDataSourceImpl
import me.simonpojok.remote.service.OrderService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private const val BASE_URL = "https://api.marketforce.com/"

@Module(includes = [RemoteDataSource.Binders::class])
@InstallIn(SingletonComponent::class)
class RemoteDataSource {

    @InstallIn(SingletonComponent::class)
    @Module
    interface Binders {
        @Binds
        fun bindsRemoteDataSource(
            remoteDataSource: RemoteDataSourceImpl
        ): RemoteDataSource
    }

    @Provides
    @Singleton
    fun providesAgencyService(retrofit: Retrofit): OrderService {
        return retrofit.create(OrderService::class.java)
    }

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        val logger = HttpLoggingInterceptor()
        logger.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
        client.addInterceptor(logger)

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(client.build())
            .build()
    }
}