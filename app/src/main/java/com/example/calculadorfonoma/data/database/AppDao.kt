package com.example.calculadorfonoma.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.calculadorfonoma.common.NetworkResponseState
import com.example.calculadorfonoma.domain.entity.RatesEntityRoom
import kotlinx.coroutines.flow.Flow


@Dao
interface AppDao {


    @Query("SELECT rate_value FROM rates WHERE currency_name = :currencyName")
     fun getRates(currencyName: String): Flow<NetworkResponseState<Double>>

            @Insert(RatesEntityRoom::class, onConflict = OnConflictStrategy.REPLACE) suspend

    fun insertRates( listRatesEntityRoom: List<RatesEntityRoom>)




}
