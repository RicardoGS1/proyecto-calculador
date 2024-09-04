package com.virtualworld3d.calculadorfonoma.domain.usecase

import com.virtualworld3d.calculadorfonoma.common.CustomSharedPreferences
import com.virtualworld3d.calculadorfonoma.common.NetworkResponseState
import com.virtualworld3d.calculadorfonoma.data.repository.LocalRepository
import com.virtualworld3d.calculadorfonoma.di.coroutine.IoDispatcher
import com.virtualworld3d.calculadorfonoma.domain.entity.RatesEntity
import com.virtualworld3d.calculadorfonoma.data.repository.RemoteRepository
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
    private val customPreferences: CustomSharedPreferences,
) : GetRatesUseCase
{
    private var refreshTime = 600000000000L
    override fun invoke(): Flow<NetworkResponseState<RatesEntity>>
    {
        val updateTime = customPreferences.getTime()
        val dif = System.nanoTime() - updateTime

        if (updateTime != null && updateTime != 0L && dif < refreshTime && dif > 0)
        {
            return getRatesFromRoom().map { response ->

                when (response)
                {
                    is NetworkResponseState.Loading -> NetworkResponseState.Loading
                    is NetworkResponseState.Success -> NetworkResponseState.Success(response.result)
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
    }
}