package com.virtualworld3d.calculadorfonoma.data.repository

import com.virtualworld3d.calculadorfonoma.common.NetworkResponseState
import com.virtualworld3d.calculadorfonoma.domain.entity.RatesEntity

import kotlinx.coroutines.flow.Flow

interface RemoteRepository {
    fun getRates(): Flow<NetworkResponseState<RatesEntity>>

}
