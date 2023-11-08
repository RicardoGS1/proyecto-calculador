package com.virtualworld.tienda_muebles_plastico.data.source.remote


import com.example.calculadorfonoma.common.NetworkResponseState
import com.example.calculadorfonoma.data.api.ApiService
import com.example.calculadorfonoma.data.dto.Rates
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
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
                val response = apiService.getRates()
                println("DataSource $response")
                emit(NetworkResponseState.Success(response))
            } catch (e: Exception)
            {
                emit(NetworkResponseState.Error(e))
            }
        }
    }

   /*

    override fun getAllCategoriesListFromApi(): Flow<NetworkResponseState<List<String>>>
    {
        return flow {
            emit(NetworkResponseState.Loading)
            try
            {
                val response = apiService.getAllCategoriesListFromApi()
                println("DataSource $response")
                emit(NetworkResponseState.Success(response))
            } catch (e: Exception)
            {
                emit(NetworkResponseState.Error(e))
            }
        }
    }

    override fun getProductsListByCategoryNameFromApi(categoryName: String): Flow<NetworkResponseState<Products>>
    {
        return flow {


            try
            {
                emit(NetworkResponseState.Loading)
                val response = apiService.getProductsListByCategoryNameFromApi(categoryName)
                emit(NetworkResponseState.Success(response))
            } catch (e: Exception)
            {
                emit(NetworkResponseState.Error(e))
            }
        }
    }

    override  fun setOrderedListForApi(listOrder: List<Order>): Flow<NetworkResponseState<Orders>>
    {



        return flow {

            println(listOrder.toString())
            emit(NetworkResponseState.Loading)
            try
            {




                val response = apiService.setSentOrderForApi(Orders(listOrder))
                emit(NetworkResponseState.Success(response))
                println("exito")

            } catch (e: Exception)
            {
                println("error")
                emit(NetworkResponseState.Error(e))

            }
        }

/*
        coroutineScope() {
            launch(Dispatchers.IO) {

                println("aaaaaaaaaaaaaaaaaaaaa"+listOrder)

                val aaa= Orders(listOrder)


                try
                {

                 val aaa =  apiService.setSentOrderForApi(aaa)
                    println(aaa.toString())


                } catch (e: Exception)
                {
                    println(e)
                }
            }

*/

        }













    override fun getSingleProductByIdFromApi(productId: Int): Flow<NetworkResponseState<Product>>
    {
        return flow {
            try
            {
                emit(NetworkResponseState.Loading)
                val response = apiService.getSingleProductByIdFromApi(productId)
                emit(NetworkResponseState.Success(response))
            } catch (e: Exception)
            {
                emit(NetworkResponseState.Error(e))
            }
        }
    }

    override fun getProductsListBySearchFromApi(query: String): Flow<NetworkResponseState<Products>>
    {
        return flow {
            emit(NetworkResponseState.Loading)
            try
            {
                val response = apiService.getProductsListBySearchFromApi(query)
                emit(NetworkResponseState.Success(response))
            } catch (e: Exception)
            {
                emit(NetworkResponseState.Error(e))
            }
        }
    }


*/

}