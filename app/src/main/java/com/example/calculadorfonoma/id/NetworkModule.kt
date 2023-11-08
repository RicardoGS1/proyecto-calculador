package com.example.calculadorfonoma.id

import com.example.calculadorfonoma.common.Constant.BASE_URL
import com.example.calculadorfonoma.data.api.ApiService

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton



@Module
@InstallIn(ViewModelComponent::class)
object ApiModule {

    @Singleton
    @Provides
    @Named("BaseUrl")
    fun provideBaseUrl() = BASE_URL


    @Singleton
    @Provides
    fun provideRetrofit(@Named("BaseUrl") baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }

    @Singleton
    @Provides
    fun restDataSource(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)



}