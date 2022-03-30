package me.simonpojok.remote

import me.simonpojok.data.RemoteDataSource
import me.simonpojok.data.model.OrderDataModel
import me.simonpojok.remote.mapper.OrderDataToRemoteMapper
import me.simonpojok.remote.mapper.OrderRemoteToDataMapper
import me.simonpojok.remote.service.OrderService
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val orderDataToRemoteMapper: OrderDataToRemoteMapper,
    private val orderRemoteToDataMapper: OrderRemoteToDataMapper,
    private val orderService: OrderService
) : RemoteDataSource {
    override suspend fun saveOrder(order: OrderDataModel): OrderDataModel {
        val response = orderService.postOrder(order = orderDataToRemoteMapper.toRemote(order))
        return orderRemoteToDataMapper.toData(response.order)
    }
}