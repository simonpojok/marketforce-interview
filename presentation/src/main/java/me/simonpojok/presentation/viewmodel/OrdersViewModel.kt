package me.simonpojok.presentation.viewModel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import me.simonpojok.domain.usecase.GetOrdersUseCase
import me.simonpojok.presentation.mapper.OrderDomainToPresentationMapper
import javax.inject.Inject

@HiltViewModel
class OrdersViewModel @Inject constructor(
    private val getOrdersUseCase: GetOrdersUseCase,
    private val orderDomainToPresentationMapper: OrderDomainToPresentationMapper
) : ViewModel() {
    val orders = getOrdersUseCase.buildUseCase(null).map { orders ->
        orders.map {
            orderDomainToPresentationMapper.toPresentation(it)
        }
    }
}