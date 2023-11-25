package com.example.calculadorfonoma.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Rates(

    @Json(name = "success")
    val success:Boolean,

    @Json(name = "timestamp")
    val timestamp:Int,

    @Json(name = "rates")
    val rates: Rate
)