package me.simonpojok.quickorder.background

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.Constraints
import androidx.work.CoroutineWorker
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import androidx.work.WorkerParameters
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import me.simonpojok.domain.usecase.SyncOrderUseCase
import me.simonpojok.domain.usecase.UpdateOrderUseCase
import me.simonpojok.domain.usecase.base.GetOrdersSyncStatusUseCase
import java.util.concurrent.TimeUnit

private const val WORKER_REPEAT_INTERVAL: Long = 40
private val WORKER_TIME_UNIT = TimeUnit.MINUTES

const val TAG = "OrderSyncWorker"

@HiltWorker
class OrderSyncWorker @AssistedInject constructor(
    @Assisted private val context: Context,
    @Assisted private val workerParams: WorkerParameters,
    private val syncOrderUseCase: SyncOrderUseCase,
    private val getOrdersSyncStatusUseCase: GetOrdersSyncStatusUseCase,
    private val updateOrderUseCase: UpdateOrderUseCase
) : CoroutineWorker(context, workerParams) {
    override suspend fun doWork(): Result {
        try {
            val orders = getOrdersSyncStatusUseCase.buildUseCase(false)
            orders.forEach { order ->
                val response = syncOrderUseCase.buildUseCase(order)
                updateOrderUseCase.buildUseCase(
                    response.copy(
                        syncStatus = true
                    )
                )

            }
        } catch (exception: Exception) {
            Log.e(TAG, "doWork: Error ${exception.message}")
        }
        return Result.success()
    }

    companion object {
        fun start(context: Context) {
            val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build()
            val workRequest = PeriodicWorkRequest.Builder(
                OrderSyncWorker::class.java,
                WORKER_REPEAT_INTERVAL,
                WORKER_TIME_UNIT
            ).setConstraints(constraints)
                .build()
            WorkManager.getInstance(context).enqueue(workRequest)
        }
    }
}