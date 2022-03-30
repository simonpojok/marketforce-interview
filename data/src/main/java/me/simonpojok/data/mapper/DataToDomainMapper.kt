package me.simonpojok.data.mapper

import me.simonpojok.data.mapper.base.BaseDataToDomainMapper
import me.simonpojok.data.model.OrderDataModel
import me.simonpojok.domain.model.OrderDomainModel
import javax.inject.Inject

class DataToDomainMapper @Inject constructor() :
    BaseDataToDomainMapper<OrderDataModel, OrderDomainModel>() {
    override fun toDomain(data: OrderDataModel) = OrderDomainModel(
        primaryKey = data.primaryKey,
        totalPrice = data.totalPrice,
        id = data.id,
        syncStatus = data.syncStatus,
        dateTime = data.dateTime,
        customerName = data.customerName
    )
}