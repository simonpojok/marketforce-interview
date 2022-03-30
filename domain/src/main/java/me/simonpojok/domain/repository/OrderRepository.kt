package me.simonpojok.domain.repository

import kotlinx.coroutines.flow.Flow
import me.simonpojok.domain.model.OrderDomainModel

interface OrderRepository {
    suspend fun saveUserOrder(order: OrderDomainModel)
    fun getOrders(): Flow<List<OrderDomainModel>>
    suspend fun syncOrder(order: OrderDomainModel): OrderDomainModel
    suspend fun getOrders(syncStatus: Boolean = false): List<OrderDomainModel>
    suspend fun updateOrder(order: OrderDomainModel)
}