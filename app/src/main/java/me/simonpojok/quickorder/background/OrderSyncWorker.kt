package me.simonpojok.quickorder.background

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import me.simonpojok.domain.usecase.SyncOrderUseCase
import me.simonpojok.domain.usecase.UpdateOrderUseCase
import me.simonpojok.domain.usecase.base.GetOrdersSyncStatusUseCase

@HiltWorker
class OrderSyncWorker @AssistedInject constructor(
    @Assisted private val context: Context,
    @Assisted private val workerParams: WorkerParameters,
    private val syncOrderUseCase: SyncOrderUseCase,
    private val getOrdersSyncStatusUseCase: GetOrdersSyncStatusUseCase,
    private val updateOrderUseCase: UpdateOrderUseCase
) : CoroutineWorker(context, workerParams) {
    override suspend fun doWork(): Result {
        val orders = getOrdersSyncStatusUseCase.buildUseCase(false)
        orders.forEach { order ->
            val response = syncOrderUseCase.buildUseCase(order)

        }
        return Result.success()
    }
}