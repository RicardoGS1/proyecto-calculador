package com.virtualworld3d.calculadorfonoma.data.mapper

import com.virtualworld3d.calculadorfonoma.domain.entity.RatesEntity
import com.virtualworld3d.calculadorfonoma.domain.entity.RatesEntityRoom
import com.virtualworld3d.calculadorfonoma.domain.mapper.RatesListToSingleMapper
import javax.inject.Inject

class ListRatesEntityRoomToRatesEntityMapper @Inject constructor() : RatesListToSingleMapper<RatesEntityRoom, RatesEntity>
{
    override fun map(input: List<RatesEntityRoom>): RatesEntity
    {

        var aa = mutableMapOf<String,Double>()

        input.forEach{
            aa[it.currencyName] = it.rateValue
        }


        return RatesEntity(
            aa
        )

    }

}