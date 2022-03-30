package me.simonpojok.remote.service

import me.simonpojok.remote.model.OrderRemoteModel
import me.simonpojok.remote.model.order.PostOrderReponse
import retrofit2.http.Body
import retrofit2.http.POST

interface OrderService {
    @POST("/orders")
    fun postOrder(@Body order: OrderRemoteModel): PostOrderReponse
}