package com.example.calculadorfonoma.data.source.remote


import com.example.calculadorfonoma.common.Constant.KEY_API
import com.example.calculadorfonoma.common.NetworkResponseState
import com.example.calculadorfonoma.data.api.ApiService
import com.example.calculadorfonoma.data.dto.Rates
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