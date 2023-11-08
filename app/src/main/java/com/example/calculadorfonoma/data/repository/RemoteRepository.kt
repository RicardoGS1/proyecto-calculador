package com.virtualworld.tienda_muebles_plastico.data.repository

import com.example.calculadorfonoma.common.NetworkResponseState
import com.example.calculadorfonoma.domain.RatesEntity

import kotlinx.coroutines.flow.Flow

interface RemoteRepository {

    fun getRates(): Flow<NetworkResponseState<List<RatesEntity>>>

   // fun getSingleProductByIdFromApi(productId: Int): Flow<NetworkResponseState<DetailProductEntity>>

   // fun getProductsListBySearchFromApi(query: String): Flow<NetworkResponseState<List<ProductEntity>>>

   // fun getAllCategoriesListFromApi(): Flow<NetworkResponseState<List<String>>>

   // fun getProductsListByCategoryNameFromApi(categoryName: String): Flow<NetworkResponseState<List<ProductEntity>>>

   // suspend fun setOrderForApi(orderInfoEntity: OrderInfoEntity, listCart: List<UserCartEntity>, onSuccess: () -> Unit, onFailure: (String) -> Unit,onLoading:() -> Unit)
}
