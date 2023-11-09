package com.example.calculadorfonoma.domain.usecase

import com.example.calculadorfonoma.common.NetworkResponseState
import com.example.calculadorfonoma.domain.entity.RatesEntity

import com.virtualworld.tienda_muebles_plastico.data.repository.RemoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRatesUseCaseImpl @Inject constructor(
    private val repository: RemoteRepository,
) : GetRatesUseCase
{


    override fun invoke(): Flow<NetworkResponseState<RatesEntity>>
    {



        return repository.getRates()



    }

  /*  override fun invoke(categoryName: String): Flow<NetworkResponseState<List<ProductEntity>>> {
        return repository.getProductsListByCategoryNameFromApi(categoryName)
    }
    */

}
