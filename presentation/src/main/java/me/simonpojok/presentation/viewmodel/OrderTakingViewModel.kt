package me.simonpojok.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import me.simonpojok.domain.usecase.CreateOrderUseCase
import me.simonpojok.presentation.mapper.OrderPresentationToDomainMapper
import me.simonpojok.presentation.model.OrderPresentationModel
import javax.inject.Inject

@HiltViewModel
class OrderTakingViewModel @Inject constructor(
    private val orderPresentationToDomainMapper: OrderPresentationToDomainMapper,
    private val createOrderUseCase: CreateOrderUseCase
) : ViewModel() {
    fun createOrder(order: OrderPresentationModel) {
        viewModelScope.launch {
            createOrderUseCase.buildUseCase(
                input = orderPresentationToDomainMapper.toDomain(order)
            )
        }
    }
}