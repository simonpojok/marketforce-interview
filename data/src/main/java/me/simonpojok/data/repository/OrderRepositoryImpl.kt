package me.simonpojok.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import me.simonpojok.data.LocalDataSource
import me.simonpojok.data.RemoteDataSource
import me.simonpojok.data.mapper.DataToDomainMapper
import me.simonpojok.data.mapper.DomainToDataMapper
import me.simonpojok.domain.model.OrderDomainModel
import me.simonpojok.domain.repository.OrderRepository
import javax.inject.Inject

class OrderRepositoryImpl @Inject constructor(
    private val dataToDomainMapper: DataToDomainMapper,
    private val domainToDataMapper: DomainToDataMapper,
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : OrderRepository {
    override suspend fun saveUserOrder(order: OrderDomainModel) {
        localDataSource.saveUserOrder(order = domainToDataMapper.toData(order))
    }

    override fun getOrders(): Flow<List<OrderDomainModel>> = localDataSource.getOrders()
        .map { orders -> orders.map { dataToDomainMapper.toDomain(it) } }

    override suspend fun getOrders(syncStatus: Boolean): List<OrderDomainModel> {
        return localDataSource.getOrders(syncStatus)
            .map { dataToDomainMapper.toDomain(it) }
    }

    override suspend fun syncOrder(order: OrderDomainModel): OrderDomainModel {
        val response = remoteDataSource.saveOrder(order = domainToDataMapper.toData(order))
        return dataToDomainMapper.toDomain(response)
    }

    override suspend fun updateOrder(order: OrderDomainModel) {
        localDataSource.updateOrder(order = domainToDataMapper.toData(order))
    }
}