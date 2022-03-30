package me.simonpojok.proder.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//@Module
//@InstallIn(SingletonComponent::class)
object LocalDataSourceLayer {
//    @Singleton
//    @Provides
//    fun providesOrderDatabase(@ApplicationContext app: Context) = OrderDatabase.getInstance(app)
//
//    @Singleton
//    @Provides
//    fun providesOrderDao(database: OrderDatabase) = database.orderDao()

//    @Singleton
//    @Provides
    fun providesString(): String {
        return "Simon"
    }
}