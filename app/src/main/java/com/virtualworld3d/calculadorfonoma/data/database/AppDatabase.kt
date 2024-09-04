package com.virtualworld3d.calculadorfonoma.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.virtualworld3d.calculadorfonoma.domain.entity.RatesEntityRoom

@Database(entities = [RatesEntityRoom::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun appDao(): AppDao
}
