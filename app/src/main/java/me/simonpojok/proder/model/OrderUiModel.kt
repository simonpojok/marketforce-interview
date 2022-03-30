package me.simonpojok.proder.model

data class OrderUiModel(
    val primaryKey: Int,
    val id: String,
    val customerName: String,
    val totalPrice: Int,
    val dateTime: String,
    val syncStatus: Boolean
)