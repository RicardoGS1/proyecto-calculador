package com.example.calculadorfonoma.data.api


import com.example.calculadorfonoma.data.dto.Rates
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface ApiService {


    @GET("latest")
    suspend fun getRates(@Query("access_key") access_key: String): Rates

  //  @GET("products/categories")
  //  suspend fun getAllCategoriesListFromApi(): List<String>

  // ?access_key=88f2f3958511dca036ccecfaf81b8355/
  //  @GET("{access_key}")
  //  suspend fun getRates(@Path("access_key") access_key: String): Rates

 //   @GET("product/{id}")
  //  suspend fun getSingleProductByIdFromApi(@Path("id") productId: Int): Product












}
