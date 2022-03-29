package me.simonpojok.proder.model

data class ProductUiModel(
    val id: Int,
    val name: String,
    val price: Int,
    val count: Int = 0
)