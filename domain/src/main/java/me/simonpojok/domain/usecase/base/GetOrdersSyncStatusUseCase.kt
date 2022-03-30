package me.simonpojok.domain.usecase.base

import me.simonpojok.domain.model.OrderDomainModel
import me.simonpojok.domain.repository.OrderRepository
import javax.inject.Inject

class GetOrdersSyncStatusUseCase @Inject constructor(
    private val orderRepository: OrderRepository
) : BaseUseCase<List<OrderDomainModel>, Boolean>() {
    override suspend fun buildUseCase(input: Boolean?): List<OrderDomainModel> {
        if (input != null) {
            return orderRepository.getOrders(input)
        }
        throw IllegalArgumentException("Input Can't Be Null")
    }
}