package com.example.calculadorfonoma.data.mapper

import com.example.calculadorfonoma.domain.entity.RatesEntity
import com.example.calculadorfonoma.domain.entity.RatesEntityRoom
import com.example.calculadorfonoma.domain.mapper.ProductListMapper
import javax.inject.Inject

class RatesEntityRoomMapper @Inject constructor() : ProductListMapper<RatesEntity, RatesEntityRoom>
{
    override fun map(input: RatesEntity): List<RatesEntityRoom>
    {
        var i=0

        fun iPlus():Int {

            return i++
        }

        return input.currencyMap.map {


            RatesEntityRoom(
                ratesId=i++,
                currencyName = it.key,
                rateValue = it.value,
            )



        }



    }

}






