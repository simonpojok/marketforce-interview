package me.simonpojok.proder

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PrOrderApplication : Application() {
//    @Inject
//    lateinit var workerFactory: HiltWorkerFactory
//
//    override fun getWorkManagerConfiguration() =
//        Configuration.Builder()
//            .setWorkerFactory(workerFactory)
//            .build()
}