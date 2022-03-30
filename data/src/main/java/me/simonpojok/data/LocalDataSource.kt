package me.simonpojok.data

import kotlinx.coroutines.flow.Flow
import me.simonpojok.data.model.OrderDataModel

interface LocalDataSource {
    suspend fun saveUserOrder(order: OrderDataModel)
    fun getOrders(): Flow<List<OrderDataModel>>
}