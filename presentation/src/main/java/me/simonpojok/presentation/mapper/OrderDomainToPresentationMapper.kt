package me.simonpojok.presentation.mapper

import me.simonpojok.domain.model.OrderDomainModel
import me.simonpojok.presentation.mapper.base.BaseDomainToPresentationMapper
import me.simonpojok.presentation.model.OrderPresentationModel
import javax.inject.Inject

class OrderDomainToPresentationMapper @Inject constructor() :
    BaseDomainToPresentationMapper<OrderDomainModel, OrderPresentationModel>() {
    override fun toPresentation(domain: OrderDomainModel) = OrderPresentationModel(
        primaryKey = domain.primaryKey,
        totalPrice = domain.totalPrice,
        id = domain.id,
        syncStatus = domain.syncStatus,
        dateTime = domain.dateTime,
        customerName = domain.customerName
    )
}