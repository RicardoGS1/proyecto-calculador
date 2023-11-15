package com.example.calculadorfonoma.ui.mapper

import com.example.calculadorfonoma.domain.entity.RatesEntity
import com.example.calculadorfonoma.ui.uiData.RatesUiData

import com.virtualworld.tienda_muebles_plastico.domain.mapper.RatesBaseMapper

import javax.inject.Inject

class RatesEntityToUiMapper @Inject constructor() : RatesBaseMapper<RatesEntity, RatesUiData>
{
    override fun map(input: RatesEntity): RatesUiData
    {




        return RatesUiData(
            USD = input.currencyMap["USD"]!!,
            NZD = input.currencyMap["USD"]!!,
            LKR = input.currencyMap["USD"]!!,
            CZK = input.currencyMap["USD"]!!,
            JPY = input.currencyMap["USD"]!!,
            PHP = input.currencyMap["USD"]!!,
            KRW = input.currencyMap["USD"]!!,
            BRL = input.currencyMap["USD"]!!,
            HKD = input.currencyMap["USD"]!!,
            RSD = input.currencyMap["USD"]!!,
            MYR = input.currencyMap["USD"]!!,
            VND = input.currencyMap["USD"]!!,
            CAD = input.currencyMap["USD"]!!,
            GBP = input.currencyMap["USD"]!!,
            NOK = input.currencyMap["USD"]!!,
            ILS = input.currencyMap["USD"]!!,
            SEK = input.currencyMap["USD"]!!,
            DKK = input.currencyMap["USD"]!!,
            AUD = input.currencyMap["USD"]!!,
            RUB = input.currencyMap["USD"]!!,
            KWD = input.currencyMap["USD"]!!,
            INR = input.currencyMap["USD"]!!,
            BND = input.currencyMap["USD"]!!,
            EUR = input.currencyMap["USD"]!!,
            ZAR = input.currencyMap["USD"]!!,
            NPR = input.currencyMap["USD"]!!,
            CNY = input.currencyMap["USD"]!!,
            CHF = input.currencyMap["USD"]!!,
            THB = input.currencyMap["USD"]!!,
            PKR = input.currencyMap["USD"]!!,
            KES = input.currencyMap["USD"]!!,
            EGP = input.currencyMap["USD"]!!,
            BDT = input.currencyMap["USD"]!!,
            SAR = input.currencyMap["USD"]!!,
            LAK = input.currencyMap["USD"]!!,
            IDR = input.currencyMap["USD"]!!,
            KHR = input.currencyMap["USD"]!!,
            SGD = input.currencyMap["USD"]!!,
            )


   }
}
