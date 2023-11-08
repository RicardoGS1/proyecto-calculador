package com.example.calculadorfonoma.domain

import com.example.calculadorfonoma.data.dto.Rate

data class RatesEntity(

    val success:String,

    val timestamp:String,

    val rates:List<Rate>
)
