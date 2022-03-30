package me.simonpojok.domain.usecase

import me.simonpojok.domain.model.OrderDomainModel
import me.simonpojok.domain.repository.OrderRepository
import me.simonpojok.domain.usecase.base.BaseUseCase
import javax.inject.Inject

class UpdateOrderUseCase @Inject constructor(
    private val orderRepository: OrderRepository
): BaseUseCase<Unit, OrderDomainModel>() {
    override suspend fun buildUseCase(input: OrderDomainModel?) {
        if (input != null) {
            return orderRepository.updateOrder(order = input)
        }

        throw IllegalArgumentException("Input can't be null")
    }
}