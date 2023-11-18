package com.example.calculadorfonoma.data.repository

import com.example.calculadorfonoma.common.NetworkResponseState
import com.example.calculadorfonoma.data.source.remote.LocalDataSource
import com.example.calculadorfonoma.di.coroutine.IoDispatcher
import com.example.calculadorfonoma.domain.entity.RatesEntity
import com.example.calculadorfonoma.domain.entity.RatesEntityRoom
import com.example.calculadorfonoma.domain.mapper.ProductListMapper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LocalRepositoryImp @Inject constructor(
    private val localDataSource: LocalDataSource,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val allProductsMapper: ProductListMapper<RatesEntity, RatesEntityRoom>,

    )  :LocalRepository{


    override suspend fun setRates(ratesEntity: RatesEntity)
    {
        withContext(ioDispatcher) {
            localDataSource.insertRates(allProductsMapper.map(ratesEntity))
        }
    }

    override suspend fun getRates(currencyName:String): Flow<NetworkResponseState<RatesEntity>>
    {

        println("getratesRoom repocitory")


        return flow {

            emit(NetworkResponseState.Success(localDataSource.getRates(currencyName)))
        }.flowOn(ioDispatcher)
    }
}