package com.virtualworld3d.calculadorfonoma.data.source.remote

import com.virtualworld3d.calculadorfonoma.common.NetworkResponseState
import com.virtualworld3d.calculadorfonoma.domain.entity.RatesEntityRoom
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    suspend fun insertRates(listRatesEntityRoom: List<RatesEntityRoom>)

    fun getRates(): Flow<NetworkResponseState<List<RatesEntityRoom>>>

}