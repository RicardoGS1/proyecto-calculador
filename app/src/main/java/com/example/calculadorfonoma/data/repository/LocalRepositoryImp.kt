package com.example.calculadorfonoma.data.repository

import com.example.calculadorfonoma.common.NetworkResponseState
import com.example.calculadorfonoma.data.source.remote.LocalDataSource
import com.example.calculadorfonoma.di.coroutine.IoDispatcher
import com.example.calculadorfonoma.domain.entity.RatesEntity
import com.example.calculadorfonoma.domain.entity.RatesEntityRoom
import com.example.calculadorfonoma.domain.mapper.ProductListMapper
import com.example.calculadorfonoma.domain.mapper.RatesListToSingleMapper
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
    private val allProductsMapper: ProductListMapper<RatesEntity, RatesEntityRoom>,
    private val getProductsMapper: RatesListToSingleMapper<RatesEntityRoom,RatesEntity >,

    )  :LocalRepository{


    override suspend fun setRates(ratesEntity: RatesEntity)
    {
        withContext(ioDispatcher) {
            localDataSource.insertRates(allProductsMapper.map(ratesEntity))
        }
    }

    override fun getRates(): Flow<NetworkResponseState<RatesEntity>>
    {

        println("getratesRoom repocitory")

        return localDataSource.getRates().map { response ->
            when (response)
            {

                is NetworkResponseState.Loading -> NetworkResponseState.Loading

                is NetworkResponseState.Success -> NetworkResponseState.Success(getProductsMapper.map(response.result))


                is NetworkResponseState.Error -> NetworkResponseState.Error(response.exception)
            }
        }.flowOn(ioDispatcher)








    }
}