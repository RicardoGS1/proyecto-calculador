package com.example.calculadorfonoma.data.repository

import com.example.calculadorfonoma.common.NetworkResponseState
import com.example.calculadorfonoma.data.dto.Rates
import com.example.calculadorfonoma.domain.entity.RatesEntity
import com.virtualworld.tienda_muebles_plastico.data.source.remote.RemoteDataSource
import com.example.calculadorfonoma.di.coroutine.IoDispatcher
import com.virtualworld.tienda_muebles_plastico.data.repository.RemoteRepository
import com.virtualworld.tienda_muebles_plastico.domain.mapper.RateListMapper
import com.virtualworld.tienda_muebles_plastico.domain.mapper.RatesBaseMapper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RemoteRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val allProductsMapper: RatesBaseMapper<Rates, RatesEntity>,

    ) : RemoteRepository
{


    override fun getRates(): Flow<NetworkResponseState<RatesEntity>>
    {


        return remoteDataSource.getRates().map { response ->
            when (response)
            {

                is NetworkResponseState.Loading -> NetworkResponseState.Loading

                is NetworkResponseState.Success -> NetworkResponseState.Success(allProductsMapper.map(response.result))


                is NetworkResponseState.Error -> NetworkResponseState.Error(response.exception)
            }
        }.flowOn(ioDispatcher)


    }
/*

    override fun getAllCategoriesListFromApi(): Flow<NetworkResponseState<List<String>>>
    {
        return remoteDataSource.getAllCategoriesListFromApi().map {
            when (it)
            {
                is NetworkResponseState.Loading -> NetworkResponseState.Loading
                is NetworkResponseState.Success -> NetworkResponseState.Success(it.result)
                is NetworkResponseState.Error -> NetworkResponseState.Error(it.exception)
            }
        }.flowOn(ioDispatcher)
    }


    override fun getSingleProductByIdFromApi(productId: Int): Flow<NetworkResponseState<DetailProductEntity>>
    {
        return remoteDataSource.getSingleProductByIdFromApi(productId).map {
            when (it)
            {
                is NetworkResponseState.Loading -> NetworkResponseState.Loading
                is NetworkResponseState.Success -> NetworkResponseState.Success(singleProductMapper.map(it.result))
                is NetworkResponseState.Error -> NetworkResponseState.Error(it.exception)
            }
        }.flowOn(ioDispatcher)
    }

    override fun getProductsListBySearchFromApi(query: String): Flow<NetworkResponseState<List<ProductEntity>>>
    {
        return remoteDataSource.getProductsListBySearchFromApi(query).map {
            when (it)
            {
                is NetworkResponseState.Loading -> NetworkResponseState.Loading
                is NetworkResponseState.Success -> NetworkResponseState.Success(allProductsMapper.map(it.result.products))
                is NetworkResponseState.Error -> NetworkResponseState.Error(it.exception)
            }
        }.flowOn(ioDispatcher)
    }


    override fun getProductsListByCategoryNameFromApi(categoryName: String): Flow<NetworkResponseState<List<ProductEntity>>>
    {
        return remoteDataSource.getProductsListByCategoryNameFromApi(categoryName).map {
            when (it)
            {
                is NetworkResponseState.Loading -> NetworkResponseState.Loading
                is NetworkResponseState.Success -> NetworkResponseState.Success(allProductsMapper.map(it.result.products))
                is NetworkResponseState.Error -> NetworkResponseState.Error(it.exception)
            }
        }.flowOn(ioDispatcher)
    }

    override suspend fun setOrderForApi(
        orderInfoEntity: OrderInfoEntity,
        listCart: List<UserCartEntity>,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit,
        onLoading: () -> Unit,
    )
    {




        remoteDataSource.setOrderedListForApi(postOrdersMapper.map(orderInfoEntity, listCart)).collect {

            when (it)
            {
                is NetworkResponseState.Loading -> onLoading()
                is NetworkResponseState.Success -> onSuccess()
                is NetworkResponseState.Error -> onFailure(it.exception.message.toString())
            }
        }


    }

    */
}
