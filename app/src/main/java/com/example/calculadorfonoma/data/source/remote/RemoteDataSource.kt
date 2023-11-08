package com.virtualworld.tienda_muebles_plastico.data.source.remote

import com.example.calculadorfonoma.common.NetworkResponseState
import com.example.calculadorfonoma.data.dto.Rates
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    fun getRates(): Flow<NetworkResponseState<Rates>>//find all products

  //  fun getSingleProductByIdFromApi(productId: Int): Flow<NetworkResponseState<Product>>//find Products by id

  //  fun getProductsListBySearchFromApi(query: String): Flow<NetworkResponseState<Products>>//search by query string--------------------------

   // fun getAllCategoriesListFromApi(): Flow<NetworkResponseState<List<String>>>//find all category

  //  fun getProductsListByCategoryNameFromApi(categoryName: String): Flow<NetworkResponseState<Products>>//find products by category name

  //   fun setOrderedListForApi(listOrder: List<Order>):  Flow<NetworkResponseState<Orders>> //send ordered for api
}
