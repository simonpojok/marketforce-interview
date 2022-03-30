package me.simonpojok.local

import kotlinx.coroutines.flow.map
import me.simonpojok.data.LocalDataSource
import me.simonpojok.data.model.OrderDataModel
import me.simonpojok.local.dao.OrderDao
import me.simonpojok.local.mapper.OrderDataToLocalMapper
import me.simonpojok.local.mapper.OrderLocalToDataMapper
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val orderDao: OrderDao,
    private val orderLocalToDataMapper: OrderLocalToDataMapper,
    private val orderDataToLocalMapper: OrderDataToLocalMapper
) :
    LocalDataSource {
    override suspend fun saveUserOrder(order: OrderDataModel) {
        orderDao.createLocalOrder(order = orderDataToLocalMapper.toLocal(order))
    }

    override fun getOrders() =
        orderDao.getOrders().map { orders -> orders.map { orderLocalToDataMapper.toData(it) } }
}