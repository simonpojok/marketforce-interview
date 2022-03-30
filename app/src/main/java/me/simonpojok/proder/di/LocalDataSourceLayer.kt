package me.simonpojok.proder.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.simonpojok.local.OrderDatabase
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object LocalDataSourceLayer {
    @Singleton
    @Provides
    fun providesOrderDao(database: OrderDatabase) = database.orderDao()
}