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
                success = input.success,
                timestamp = input.timestamp,
                rates = input.rates
            )

    }
}
