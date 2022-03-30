package me.simonpojok.domain.usecase

import kotlinx.coroutines.flow.Flow
import me.simonpojok.domain.model.OrderDomainModel
import me.simonpojok.domain.repository.OrderRepository
import me.simonpojok.domain.usecase.base.FlowableBaseUseCase
import javax.inject.Inject

class GetOrdersUseCase @Inject constructor(
    private val orderRepository: OrderRepository
) : FlowableBaseUseCase<Flow<List<OrderDomainModel>>, GetOrdersUseCase.Params>() {
    data class Params(val count: Int)

    override fun buildUseCase(input: Params?): Flow<List<OrderDomainModel>> {
        return orderRepository.getOrders()
    }
}