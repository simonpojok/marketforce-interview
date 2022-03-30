package me.simonpojok.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "orders")
data class OrderLocalModel(
    @PrimaryKey(autoGenerate = true)
    val primary_key: Int = 0,
    val id: String,
    val customer_name: String,
    val total_price: Int,
    val date_time: String,
    val sync_status: Boolean = false
)