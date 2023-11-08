package com.example.calculadorfonoma.data.api


import com.example.calculadorfonoma.data.dto.Rates
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

   @GET()
    suspend fun getRates(): Rates

  //  @GET("products/categories")
  //  suspend fun getAllCategoriesListFromApi(): List<String>


  //  @GET("products/categories/{categoryName}")
 //   suspend fun getProductsListByCategoryNameFromApi(@Path("categoryName") categoryName: String): Products

 //   @GET("product/{id}")
  //  suspend fun getSingleProductByIdFromApi(@Path("id") productId: Int): Product












}
