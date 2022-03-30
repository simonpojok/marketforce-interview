package me.simonpojok.presentation.model

data class OrderPresentationModel(
    val primaryKey: Int,
    val id: String,
    val customerName: String,
    val totalPrice: Int,
    val dateTime: String,
    val syncStatus: Boolean
)