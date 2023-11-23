package com.example.calculadorfonoma.data.source.remote

import com.example.calculadorfonoma.common.NetworkResponseState
import com.example.calculadorfonoma.data.database.AppDao
import com.example.calculadorfonoma.domain.entity.RatesEntityRoom
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LocalDataSourceImp  @Inject constructor(private val appDao: AppDao)  :LocalDataSource{
    override suspend fun insertRates(listRatesEntityRoom: List<RatesEntityRoom>)
    {
        appDao.insertRates(listRatesEntityRoom)
    }

    /44
    override fun getRates(): Flow<NetworkResponseState<List<RatesEntityRoom>>>
    {
        return flow {
            emit(NetworkResponseState.Loading)
            try
            {
                val response = appDao.getRates()
                emit(NetworkResponseState.Success(response))

            } catch (e: Exception)
            {
                emit(NetworkResponseState.Error(e))
            }
        }
    }
}