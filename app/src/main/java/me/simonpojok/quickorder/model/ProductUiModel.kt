package me.simonpojok.quickorder.model

data class ProductUiModel(
    val id: Int,
    val name: String,
    val price: Int,
    val count: Int = 0
)