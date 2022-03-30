package me.simonpojok.quickorder.mapper

import me.simonpojok.presentation.model.OrderPresentationModel
import me.simonpojok.quickorder.mapper.base.BasePresentationToUiMapper
import me.simonpojok.quickorder.model.OrderUiModel
import javax.inject.Inject

class OrderPresentationToUiMapper @Inject constructor() :
    BasePresentationToUiMapper<OrderUiModel, OrderPresentationModel>() {

    override fun toUi(presentation: OrderPresentationModel) = OrderUiModel(
        primaryKey = presentation.primaryKey,
        totalPrice = presentation.totalPrice,
        id = presentation.id,
        syncStatus = presentation.syncStatus,
        dateTime = presentation.dateTime,
        customerName = presentation.customerName
    )
}