package me.simonpojok.quickorder.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.simonpojok.data.LocalDataSource
import me.simonpojok.data.RemoteDataSource
import me.simonpojok.data.repository.OrderRepositoryImpl
import me.simonpojok.domain.repository.OrderRepository
import me.simonpojok.local.LocalDataSourceImpl
import me.simonpojok.remote.RemoteDataSourceImpl
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class DataSourceLayer {

    @Singleton
    @Binds
    abstract fun bindsLocalDataSource(
        localDataSource: LocalDataSourceImpl
    ): LocalDataSource

    @Singleton
    @Binds
    abstract fun bindsRemoteDataSource(
        localDataSource: RemoteDataSourceImpl
    ): RemoteDataSource

    @Singleton
    @Binds
    abstract fun bindsDeclarationRepository(
        orderRepositoryImpl: OrderRepositoryImpl
    ): OrderRepository
}