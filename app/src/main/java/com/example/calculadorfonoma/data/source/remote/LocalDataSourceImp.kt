package com.example.calculadorfonoma.data.source.remote

import com.example.calculadorfonoma.common.Constant
import com.example.calculadorfonoma.common.NetworkResponseState
import com.example.calculadorfonoma.data.database.AppDao
import com.example.calculadorfonoma.domain.entity.RatesEntity
import com.example.calculadorfonoma.domain.entity.RatesEntityRoom
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalDataSourceImp  @Inject constructor(private val appDao: AppDao)  :LocalDataSource{
    override suspend fun insertRates(listRatesEntityRoom: List<RatesEntityRoom>)
    {
        appDao.insertRates(listRatesEntityRoom)
    }

    override fun getRates(currencyName:String): RatesEntity
    {

        return flow {
            emit(NetworkResponseState.Loading)
            try
            {
                val response = apiService.getRates(Constant.KEY_API)
                emit(NetworkResponseState.Success(response))
            } catch (e: Exception)
            {
                emit(NetworkResponseState.Error(e))
            }
        }










        println("getratesRoom dataSource")

        appDao.getRates(currencyName).map {



        }

      return  RatesEntity (

          mutableMapOf(
              currencyName to appDao.getRates(currencyName).collect{

              },
        )
      )




    }


}