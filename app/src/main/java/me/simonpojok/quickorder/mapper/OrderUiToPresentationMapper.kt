package me.simonpojok.quickorder.mapper

import me.simonpojok.presentation.model.OrderPresentationModel
import me.simonpojok.quickorder.mapper.base.BaseUiToPresentationMapper
import me.simonpojok.quickorder.model.OrderUiModel
import javax.inject.Inject

class OrderUiToPresentationMapper @Inject constructor() :
    BaseUiToPresentationMapper<OrderUiModel, OrderPresentationModel>() {
    override fun toPresentation(ui: OrderUiModel) = OrderPresentationModel(
        primaryKey = ui.primaryKey,
        totalPrice = ui.totalPrice,
        id = ui.id,
        syncStatus = ui.syncStatus,
        dateTime = ui.dateTime,
        customerName = ui.customerName
    )
}