package me.simonpojok.data.model

data class OrderDataModel(
    val primaryKey: Int,
    val id: String,
    val customerName: String,
    val totalPrice: Int,
    val dateTime: String,
    val syncStatus: Boolean
)