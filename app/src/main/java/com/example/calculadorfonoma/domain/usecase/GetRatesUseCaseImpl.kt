package com.example.calculadorfonoma.domain.usecase

import com.example.calculadorfonoma.common.CustomSharedPreferences
import com.example.calculadorfonoma.common.NetworkResponseState
import com.example.calculadorfonoma.data.repository.LocalRepository
import com.example.calculadorfonoma.di.coroutine.IoDispatcher
import com.example.calculadorfonoma.domain.entity.RatesEntity
import com.virtualworld.tienda_muebles_plastico.data.repository.RemoteRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetRatesUseCaseImpl @Inject constructor(
    private val repository: RemoteRepository,
    private val localRepository: LocalRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val customPreferences: CustomSharedPreferences
) : GetRatesUseCase
{

    private var refreshTime = 600000000000L


    override fun invoke(): Flow<NetworkResponseState<RatesEntity>>
    {
        //  val calendar = Calendar.getInstance()
        // val minutes: Int = calendar.get(Calendar.MINUTE)

        val updateTime = customPreferences.getTime()  //0

        val aa = System.nanoTime() - updateTime

        println(System.nanoTime().toString() + "           " + updateTime + "          " + aa)

        //updateTime != null && updateTime != 0L && aa < refreshTime

        val a =1

        if (updateTime != null && updateTime != 0L && aa < refreshTime && aa > 0 )
        {


            return getRatesFromRoom().map { response ->

                when (response)
                {

                    is NetworkResponseState.Loading -> NetworkResponseState.Loading

                    is NetworkResponseState.Success ->
                    {

                        NetworkResponseState.Success(response.result)
                    }


                    is NetworkResponseState.Error -> NetworkResponseState.Error(response.exception)
                }
            }.flowOn(ioDispatcher)

        } else
        {

            return getRatesFromApi().map { response ->
                when (response)
                {

                    is NetworkResponseState.Loading -> NetworkResponseState.Loading

                    is NetworkResponseState.Success ->
                    {
                        setRatesFromRoom(response.result)

                        customPreferences.saveTime(System.nanoTime())
                        println("refresh time")

                        NetworkResponseState.Success(response.result)
                    }


                    is NetworkResponseState.Error -> NetworkResponseState.Error(response.exception)
                }
            }.flowOn(ioDispatcher)

        }
    }

    private suspend fun setRatesFromRoom(result: RatesEntity)
    {
        localRepository.setRates(result)
    }

    private fun getRatesFromApi(): Flow<NetworkResponseState<RatesEntity>>
    {

        println("getFromApi")

        return repository.getRates()
    }

    private fun getRatesFromRoom(): Flow<NetworkResponseState<RatesEntity>>
    {
        println("getFromRoom")


        return localRepository.getRates()

      /*
        localRepository.getRates()

      return runBlocking(Dispatchers.IO){

            println("getFromRoom")
            //  val a =  localRepository.getRates("USD")


           return@runBlocking localRepository.getRates("USD")

                //    return@runBlocking localRepository.getRates("USD")



            // return flow {
            //   emit(NetworkResponseState.Loading)


        }

// return flow {
  //         emit(NetworkResponseState.Loading)
  //  }

       */
}
}