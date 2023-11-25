package com.example.calculadorfonoma.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.calculadorfonoma.domain.entity.RatesEntityRoom

@Database(entities = [RatesEntityRoom::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun appDao(): AppDao
}
