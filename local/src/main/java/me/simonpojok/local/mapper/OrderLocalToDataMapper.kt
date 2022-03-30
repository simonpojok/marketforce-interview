package me.simonpojok.local.mapper

import me.simonpojok.data.model.OrderDataModel
import me.simonpojok.local.mapper.base.BaseLocalToDataMapper
import me.simonpojok.local.model.OrderLocalModel
import javax.inject.Inject

class OrderLocalToDataMapper @Inject constructor() :
    BaseLocalToDataMapper<OrderLocalModel, OrderDataModel>() {
    override fun toData(data: OrderLocalModel) = OrderDataModel(
        primaryKey = data.primary_key,
        totalPrice = data.total_price,
        customerName = data.customer_name,
        id = data.id,
        dateTime = data.date_time,
        syncStatus = data.sync_status
    )
}