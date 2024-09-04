package com.virtualworld3d.calculadorfonoma.data.source.remote

import com.virtualworld3d.calculadorfonoma.common.NetworkResponseState
import com.virtualworld3d.calculadorfonoma.data.dto.Rates
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    fun getRates(): Flow<NetworkResponseState<Rates>>

}
