package me.simonpojok.remote.model.order

import me.simonpojok.remote.model.OrderRemoteModel

data class PostOrderResponse(
    val statusCode: Int,
    val message: String,
    val order: OrderRemoteModel
)