package com.virtualworld3d.calculadorfonoma.domain.usecase

import com.virtualworld3d.calculadorfonoma.common.NetworkResponseState
import com.virtualworld3d.calculadorfonoma.domain.entity.RatesEntity

import kotlinx.coroutines.flow.Flow

interface GetRatesUseCase {
    operator fun invoke(): Flow<NetworkResponseState<RatesEntity>>

}
