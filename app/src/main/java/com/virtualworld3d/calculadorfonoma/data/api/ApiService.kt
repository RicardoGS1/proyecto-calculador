package com.virtualworld3d.calculadorfonoma.data.api


import com.virtualworld3d.calculadorfonoma.data.dto.Rates
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("latest")
    suspend fun getRates(@Query("access_key") access_key: String): Rates

}
