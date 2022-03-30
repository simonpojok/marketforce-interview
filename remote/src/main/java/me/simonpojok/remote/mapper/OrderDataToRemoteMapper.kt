package me.simonpojok.remote.mapper

import me.simonpojok.data.model.OrderDataModel
import me.simonpojok.remote.mapper.base.BaseDataToRemoteMapper
import me.simonpojok.remote.model.OrderRemoteModel
import javax.inject.Inject

class OrderDataToRemoteMapper @Inject constructor() :
    BaseDataToRemoteMapper<OrderRemoteModel, OrderDataModel>() {
    override fun toRemote(data: OrderDataModel) = OrderRemoteModel(
        primaryKey = data.primaryKey,
        totalPrice = data.totalPrice,
        _id = data.id,
        syncStatus = data.syncStatus,
        dateTime = data.dateTime,
        customerName = data.customerName
    )
}