package com.example.calculadorfonoma.domain.entity

import com.example.calculadorfonoma.data.dto.Rate

data class RatesEntity(

    val success: Boolean,

    val timestamp: Int,

    val rates:Rate
)
