package me.simonpojok.domain.usecase

import me.simonpojok.domain.model.OrderDomainModel
import me.simonpojok.domain.repository.OrderRepository
import me.simonpojok.domain.usecase.base.BaseUseCase
import java.lang.IllegalArgumentException
import javax.inject.Inject

class CreateOrderUseCase @Inject constructor(
    private val orderRepository: OrderRepository
): BaseUseCase<Unit, OrderDomainModel>() {
    override suspend fun buildUseCase(input: OrderDomainModel?) {
        if (input != null) {
            return orderRepository.saveUserOrder(input)
        }

        throw IllegalArgumentException("Input Can't be null")
    }
}