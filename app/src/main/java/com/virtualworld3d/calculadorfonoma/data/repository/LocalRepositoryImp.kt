package com.virtualworld3d.calculadorfonoma.data.repository

import com.virtualworld3d.calculadorfonoma.common.NetworkResponseState
import com.virtualworld3d.calculadorfonoma.data.source.remote.LocalDataSource
import com.virtualworld3d.calculadorfonoma.di.coroutine.IoDispatcher
import com.virtualworld3d.calculadorfonoma.domain.entity.RatesEntity
import com.virtualworld3d.calculadorfonoma.domain.entity.RatesEntityRoom
import com.virtualworld3d.calculadorfonoma.domain.mapper.RatesListToSingleMapper
import com.virtualworld3d.calculadorfonoma.domain.mapper.RatesSingleToListMapper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LocalRepositoryImp @Inject constructor(
    private val localDataSource: LocalDataSource,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val ratesSingleToListMapper: RatesSingleToListMapper<RatesEntity, RatesEntityRoom>,
    private val ratesListToSingleMapper: RatesListToSingleMapper<RatesEntityRoom, RatesEntity>,
) : LocalRepository
{


    override suspend fun setRates(ratesEntity: RatesEntity)
    {
        withContext(ioDispatcher) {
            localDataSource.insertRates(ratesSingleToListMapper.map(ratesEntity))
        }
    }

    override fun getRates(): Flow<NetworkResponseState<RatesEntity>>
    {

        return localDataSource.getRates().map { response ->
            when (response)
            {

                is NetworkResponseState.Loading -> NetworkResponseState.Loading

                is NetworkResponseState.Success -> NetworkResponseState.Success(ratesListToSingleMapper.map(response.result))


                is NetworkResponseState.Error -> NetworkResponseState.Error(response.exception)
            }
        }.flowOn(ioDispatcher)

    }
}