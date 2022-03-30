package me.simonpojok.domain.repository

import me.simonpojok.domain.model.OrderDomainModel

interface OrderRepository {
    suspend fun saveUserOrder(order: OrderDomainModel)
}