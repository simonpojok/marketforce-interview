package me.simonpojok.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import me.simonpojok.data.LocalDataSource
import me.simonpojok.data.mapper.DataToDomainMapper
import me.simonpojok.data.mapper.DomainToDataMapper
import me.simonpojok.domain.model.OrderDomainModel
import me.simonpojok.domain.repository.OrderRepository
import javax.inject.Inject

class OrderRepositoryImpl @Inject constructor(
    private val dataToDomainMapper: DataToDomainMapper,
    private val domainToDataMapper: DomainToDataMapper,
    private val localDataSource: LocalDataSource
) : OrderRepository {
    override suspend fun saveUserOrder(order: OrderDomainModel) {
        localDataSource.saveUserOrder(order = domainToDataMapper.toData(order))
    }

    override fun getOrders(): Flow<List<OrderDomainModel>> {
        return localDataSource.getOrders()
            .map { orders -> orders.map { dataToDomainMapper.toDomain(it) } }
    }
}