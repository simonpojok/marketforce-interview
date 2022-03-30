package me.simonpojok.data.mapper

import me.simonpojok.data.mapper.base.BaseDomainToDataMapper
import me.simonpojok.data.model.OrderDataModel
import me.simonpojok.domain.model.OrderDomainModel
import javax.inject.Inject

class DomainToDataMapper @Inject constructor() :
    BaseDomainToDataMapper<OrderDomainModel, OrderDataModel>() {
    override fun toData(domain: OrderDomainModel) = OrderDataModel(
        primaryKey = domain.primaryKey,
        totalPrice = domain.totalPrice,
        id = domain.id,
        syncStatus = domain.syncStatus,
        dateTime = domain.dateTime,
        customerName = domain.customerName
    )
}