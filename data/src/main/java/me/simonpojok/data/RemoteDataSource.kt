package me.simonpojok.data

import me.simonpojok.data.model.OrderDataModel

interface RemoteDataSource {
    suspend fun saveOrder(order: OrderDataModel): OrderDataModel
}