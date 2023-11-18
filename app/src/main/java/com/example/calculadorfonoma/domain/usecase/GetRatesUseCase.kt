package com.example.calculadorfonoma.domain.usecase

import com.example.calculadorfonoma.common.NetworkResponseState
import com.example.calculadorfonoma.domain.entity.RatesEntity

import kotlinx.coroutines.flow.Flow

interface GetRatesUseCase {
    operator fun invoke(): Flow<NetworkResponseState<RatesEntity>>

}
