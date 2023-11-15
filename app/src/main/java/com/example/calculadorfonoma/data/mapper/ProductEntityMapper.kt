package com.example.calculadorfonoma.data.mapper

import com.example.calculadorfonoma.data.dto.Rates
import com.example.calculadorfonoma.domain.entity.RatesEntity
import com.virtualworld.tienda_muebles_plastico.domain.mapper.RatesBaseMapper
import javax.inject.Inject

class RatesEntityMapper @Inject constructor() : RatesBaseMapper<Rates, RatesEntity>
{
    override fun map(input: Rates): RatesEntity
    {
        return RatesEntity(

            mutableMapOf("USD" to input.rates.USD,
                         "NZD" to input.rates.NZD,
                         "LKR" to input.rates.LKR,
                         "CZK" to input.rates.CZK,
                         "JPY" to input.rates.JPY,
                         "PHP" to input.rates.PHP,
                         "KRW" to input.rates.KRW,
                         "BRL" to input.rates.BRL,
                         "HKD" to input.rates.HKD,
                         "RSD" to input.rates.RSD,
                         "MYR" to input.rates.MYR,
                         "VND" to input.rates.VND,
                         "CAD" to input.rates.CAD,
                         "GBP" to input.rates.GBP,
                         "NOK" to input.rates.NOK,
                         "ILS" to input.rates.ILS,
                         "SEK" to input.rates.SEK,
                         "DKK" to input.rates.DKK,
                         "AUD" to input.rates.AUD,
                         "RUB" to input.rates.RUB,
                         "KWD" to input.rates.KWD,
                         "INR" to input.rates.INR,
                         "BND" to input.rates.BND,
                         "EUR" to input.rates.EUR,
                         "ZAR" to input.rates.ZAR,
                         "NPR" to input.rates.NPR,
                         "CNY" to input.rates.CNY,
                         "CHF" to input.rates.CHF,
                         "THB" to input.rates.THB,
                         "PKR" to input.rates.PKR,
                         "KES" to input.rates.KES,
                         "EGP" to input.rates.EGP,
                         "BDT" to input.rates.BDT,
                         "SAR" to input.rates.SAR,
                         "LAK" to input.rates.LAK,
                         "IDR" to input.rates.IDR,
                         "KHR" to input.rates.KHR,
                         "SGD" to input.rates.SGD)


            //  success = input.success,
            //  timestamp = input.timestamp,
            //  rates = input.rates
        )

    }
}
