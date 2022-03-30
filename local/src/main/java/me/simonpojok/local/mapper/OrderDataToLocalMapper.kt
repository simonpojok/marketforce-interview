package me.simonpojok.local.mapper

import me.simonpojok.data.model.OrderDataModel
import me.simonpojok.local.mapper.base.BaseDataToLocalMapper
import me.simonpojok.local.model.OrderLocalModel
import javax.inject.Inject

class OrderDataToLocalMapper @Inject constructor() :
    BaseDataToLocalMapper<OrderDataModel, OrderLocalModel>() {
    override fun toLocal(data: OrderDataModel) = OrderLocalModel(
        primary_key = data.primaryKey,
        id = data.id,
        customer_name = data.customerName,
        total_price = data.totalPrice,
        date_time = data.dateTime
    )
}