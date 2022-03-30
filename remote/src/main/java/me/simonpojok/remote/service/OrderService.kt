package me.simonpojok.remote.service

import me.simonpojok.remote.model.OrderRemoteModel
import me.simonpojok.remote.model.order.PostOrderResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface OrderService {
    @POST("/api/orders/orders")
    suspend fun postOrder(@Body order: OrderRemoteModel): PostOrderResponse
}