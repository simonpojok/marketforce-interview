package me.simonpojok.remote.mapper

import me.simonpojok.data.model.OrderDataModel
import me.simonpojok.remote.mapper.base.BaseRemoteToDataMapper
import me.simonpojok.remote.model.OrderRemoteModel
import javax.inject.Inject

class OrderRemoteToDataMapper @Inject constructor() :
    BaseRemoteToDataMapper<OrderRemoteModel, OrderDataModel>() {
    override fun toData(remote: OrderRemoteModel) = OrderDataModel(
        primaryKey = remote.primaryKey,
        totalPrice = remote.totalPrice,
        id = remote._id,
        syncStatus = remote.syncStatus,
        dateTime = remote.dateTime,
        customerName = remote.customerName
    )
}