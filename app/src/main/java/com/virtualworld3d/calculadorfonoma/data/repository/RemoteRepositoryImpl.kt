package com.virtualworld3d.calculadorfonoma.data.repository

import com.virtualworld3d.calculadorfonoma.common.NetworkResponseState
import com.virtualworld3d.calculadorfonoma.data.dto.Rates
import com.virtualworld3d.calculadorfonoma.data.source.remote.RemoteDataSource
import com.virtualworld3d.calculadorfonoma.di.coroutine.IoDispatcher
import com.virtualworld3d.calculadorfonoma.domain.entity.RatesEntity
import com.virtualworld3d.calculadorfonoma.domain.mapper.RatesBaseMapper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RemoteRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val ratesListToSingleMapper: RatesBaseMapper<Rates, RatesEntity>,
) : RemoteRepository
{



    override fun getRates(): Flow<NetworkResponseState<RatesEntity>>
    {
        return remoteDataSource.getRates().map { response ->
            when (response)
            {

                is NetworkResponseState.Loading -> NetworkResponseState.Loading

                is NetworkResponseState.Success -> NetworkResponseState.Success(ratesListToSingleMapper.map(response.result))


                is NetworkResponseState.Error -> NetworkResponseState.Error(response.exception)
            }
        }.flowOn(ioDispatcher)

    }

}
