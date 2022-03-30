package me.simonpojok.remote.model

data class OrderRemoteModel(
    val primaryKey: Int,
    val id: String,
    val customerName: String,
    val totalPrice: Int,
    val dateTime: String,
    val syncStatus: Boolean
)