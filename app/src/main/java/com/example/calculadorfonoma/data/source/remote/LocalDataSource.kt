package com.example.calculadorfonoma.data.source.remote

import com.example.calculadorfonoma.common.NetworkResponseState
import com.example.calculadorfonoma.domain.entity.RatesEntityRoom
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    suspend fun insertRates(listRatesEntityRoom: List<RatesEntityRoom>)

    fun getRates(): Flow<NetworkResponseState<List<RatesEntityRoom>>>

}