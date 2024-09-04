package com.virtualworld3d.calculadorfonoma.data.source.remote


import com.virtualworld3d.calculadorfonoma.common.Constant.KEY_API
import com.virtualworld3d.calculadorfonoma.common.NetworkResponseState
import com.virtualworld3d.calculadorfonoma.data.api.ApiService
import com.virtualworld3d.calculadorfonoma.data.dto.Rates
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService,
) : RemoteDataSource
{



    override fun getRates(): Flow<NetworkResponseState<Rates>>
    {
        return flow {
            emit(NetworkResponseState.Loading)
            try
            {
                val response = apiService.getRates(KEY_API)
                emit(NetworkResponseState.Success(response))
            } catch (e: Exception)
            {
                emit(NetworkResponseState.Error(e))
            }
        }
    }


}