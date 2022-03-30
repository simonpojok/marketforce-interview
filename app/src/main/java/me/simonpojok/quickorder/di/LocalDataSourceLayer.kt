package me.simonpojok.quickorder.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import me.simonpojok.local.OrderDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalDataSourceLayer {
    @Singleton
    @Provides
    fun providesOrderDatabase(@ApplicationContext app: Context) = OrderDatabase.getInstance(app)

    @Singleton
    @Provides
    fun providesOrderDao(database: OrderDatabase) = database.orderDao()
}