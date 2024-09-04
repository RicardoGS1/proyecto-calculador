package com.virtualworld3d.calculadorfonoma.data.mapper

import com.virtualworld3d.calculadorfonoma.domain.entity.RatesEntity
import com.virtualworld3d.calculadorfonoma.domain.entity.RatesEntityRoom
import com.virtualworld3d.calculadorfonoma.domain.mapper.RatesSingleToListMapper
import javax.inject.Inject

class RatesEntityToListRatesEntityRoomMapper @Inject constructor() : RatesSingleToListMapper<RatesEntity, RatesEntityRoom>
{
    override fun map(input: RatesEntity): List<RatesEntityRoom>
    {
        var i=0

        return input.currencyMap.map {

            RatesEntityRoom(
                ratesId=i++,
                currencyName = it.key,
                rateValue = it.value,
            )
        }
    }
}






