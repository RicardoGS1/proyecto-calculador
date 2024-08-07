package com.example.calculadorfonoma.data.source.remote

import com.example.calculadorfonoma.common.NetworkResponseState
import com.example.calculadorfonoma.data.dto.Rates
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    fun getRates(): Flow<NetworkResponseState<Rates>>

}
