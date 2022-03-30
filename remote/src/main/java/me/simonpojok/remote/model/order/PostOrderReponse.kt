package me.simonpojok.remote.model.order

data class PostOrderReponse(
    val statusCode: Int,
    val message: String,
    val order: OrderRemoteModel
)