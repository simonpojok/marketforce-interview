package me.simonpojok.domain.usecase

import me.simonpojok.domain.model.OrderDomainModel
import me.simonpojok.domain.repository.OrderRepository
import me.simonpojok.domain.usecase.base.BaseUseCase
import javax.inject.Inject

class SyncOrderUseCase @Inject constructor(
    private val orderRepository: OrderRepository
) : BaseUseCase<OrderDomainModel, OrderDomainModel>() {
    override suspend fun buildUseCase(input: OrderDomainModel?): OrderDomainModel {
        if (input != null) {
            return orderRepository.syncOrder(input)
        }
        throw IllegalArgumentException("Input Must Not Be Null")
    }
}