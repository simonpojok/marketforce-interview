package me.simonpojok.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import me.simonpojok.local.model.OrderLocalModel

@Dao
interface OrderDao {
    @Insert
    suspend fun createLocalOrder(order: OrderLocalModel)

    @Update
    suspend fun updateLocalOrder(order: OrderLocalModel)

    @Query("SELECT * FROM orders")
    fun getOrders(): Flow<List<OrderLocalModel>>

    @Query("SELECT * FROM orders WHERE sync_status=:syncStatus")
    fun getOrders(syncStatus: Boolean = false): Flow<List<OrderLocalModel>>
}