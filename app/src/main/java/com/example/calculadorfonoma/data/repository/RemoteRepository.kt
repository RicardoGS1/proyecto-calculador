package com.example.calculadorfonoma.data.repository

import com.example.calculadorfonoma.common.NetworkResponseState
import com.example.calculadorfonoma.domain.entity.RatesEntity

import kotlinx.coroutines.flow.Flow

interface RemoteRepository {
    fun getRates(): Flow<NetworkResponseState<RatesEntity>>

}
