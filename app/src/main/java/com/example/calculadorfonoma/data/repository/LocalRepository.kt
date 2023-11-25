package com.example.calculadorfonoma.data.repository

import com.example.calculadorfonoma.common.NetworkResponseState
import com.example.calculadorfonoma.domain.entity.RatesEntity
import kotlinx.coroutines.flow.Flow

interface LocalRepository {
    suspend fun setRates(ratesEntity: RatesEntity)

    fun getRates(): Flow<NetworkResponseState<RatesEntity>>

}