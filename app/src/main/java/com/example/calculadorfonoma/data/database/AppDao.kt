package com.example.calculadorfonoma.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.calculadorfonoma.domain.entity.RatesEntityRoom


@Dao
interface AppDao
{
    @Query("SELECT * FROM rates")
    suspend fun getRates():List<RatesEntityRoom>

    @Insert(RatesEntityRoom::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRates(listRatesEntityRoom: List<RatesEntityRoom>)

}
