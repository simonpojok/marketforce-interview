package me.simonpojok.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import me.simonpojok.local.model.OrderLocalModel

@Dao
interface OrderDao {
    @Insert
    suspend fun createLocalOrder(order: OrderLocalModel)

    @Update
    suspend fun updateLocalOrder(order: OrderLocalModel)

    @Query("SELECT * FROM orders")
    suspend fun getOrders(): List<OrderLocalModel>

    @Query("SELECT * FROM orders WHERE sync_status=:syncStatus")
    suspend fun getOrders(syncStatus: Boolean = false): List<OrderLocalModel>
}