package me.simonpojok.local

import android.content.Context
import androidx.annotation.NonNull
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import me.simonpojok.local.dao.OrderDao
import me.simonpojok.local.model.OrderLocalModel

@Database(
    entities = [
        OrderLocalModel::class,
    ],
    version = 1,
    exportSchema = false
)
abstract class OrderDatabase : RoomDatabase() {
    abstract fun orderDao(): OrderDao

    companion object {
        private val LOCK = Any()
        private val DATABASE_NAME = "order_database.db"

        @Volatile
        private var INSTANCE: OrderDatabase? = null

        fun getInstance(@NonNull context: Context): OrderDatabase {
            if (INSTANCE == null) {
                synchronized(LOCK) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context,
                            OrderDatabase::class.java,
                            DATABASE_NAME,
                        ).build();
                    }
                }
            }
            return INSTANCE!!
        }
    }
}