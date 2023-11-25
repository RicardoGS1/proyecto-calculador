package com.example.calculadorfonoma.data.mapper

import com.example.calculadorfonoma.domain.entity.RatesEntity
import com.example.calculadorfonoma.domain.entity.RatesEntityRoom
import com.example.calculadorfonoma.domain.mapper.RatesSingleToListMapper
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






