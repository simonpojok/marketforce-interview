package me.simonpojok.presentation.mapper

import me.simonpojok.domain.model.OrderDomainModel
import me.simonpojok.presentation.mapper.base.BasePresentationToDomainMapper
import me.simonpojok.presentation.model.OrderPresentationModel
import javax.inject.Inject

class OrderPresentationToDomainMapper @Inject constructor() :
    BasePresentationToDomainMapper<OrderDomainModel, OrderPresentationModel>() {

    override fun toDomain(presentation: OrderPresentationModel) = OrderDomainModel(
        primaryKey = presentation.primaryKey,
        totalPrice = presentation.totalPrice,
        id = presentation.id,
        syncStatus = presentation.syncStatus,
        dateTime = presentation.dateTime,
        customerName = presentation.customerName
    )
}