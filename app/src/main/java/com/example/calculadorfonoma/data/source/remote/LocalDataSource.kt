package com.example.calculadorfonoma.data.source.remote

import com.example.calculadorfonoma.domain.entity.RatesEntity
import com.example.calculadorfonoma.domain.entity.RatesEntityRoom

interface LocalDataSource {

    suspend fun insertRates(listRatesEntityRoom: List<RatesEntityRoom>)

    fun getRates(currencyName:String): RatesEntity

}