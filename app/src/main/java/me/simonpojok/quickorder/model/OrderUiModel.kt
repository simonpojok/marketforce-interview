package me.simonpojok.quickorder.model

data class OrderUiModel(
    val primaryKey: Int = 0,
    val id: String = "",
    val customerName: String,
    val totalPrice: Int,
    val dateTime: String,
    val syncStatus: Boolean = false
)