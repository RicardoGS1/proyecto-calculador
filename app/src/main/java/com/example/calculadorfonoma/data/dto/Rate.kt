package com.example.calculadorfonoma.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class Rate(

    @Json(name = "USD") val USD: Double = 0.0,
    @Json(name = "NZD") val NZD: Double = 0.0,
    @Json(name = "LKR") val LKR: Double = 0.0,
    @Json(name = "CZK") val CZK: Double = 0.0,
    @Json(name = "JPY") val JPY: Double = 0.0,
    @Json(name = "PHP") val PHP: Double = 0.0,
    @Json(name = "KRW") val KRW: Double = 0.0,
    @Json(name = "BRL") val BRL: Double = 0.0,
    @Json(name = "HKD") val HKD: Double = 0.0,
    @Json(name = "RSD") val RSD: Double = 0.0,
    @Json(name = "MYR") val MYR: Double = 0.0,
    @Json(name = "VND") val VND: Double = 0.0,
    @Json(name = "CAD") val CAD: Double = 0.0,
    @Json(name = "GBP") val GBP: Double = 0.0,
    @Json(name = "NOK") val NOK: Double = 0.0,
    @Json(name = "ILS") val ILS: Double = 0.0,
    @Json(name = "SEK") val SEK: Double = 0.0,
    @Json(name = "DKK") val DKK: Double = 0.0,
    @Json(name = "AUD") val AUD: Double = 0.0,
    @Json(name = "RUB") val RUB: Double = 0.0,
    @Json(name = "KWD") val KWD: Double = 0.0,
    @Json(name = "INR") val INR: Double = 0.0,
    @Json(name = "BND") val BND: Double = 0.0,
    @Json(name = "EUR") val EUR: Double = 0.0,
    @Json(name = "ZAR") val ZAR: Double = 0.0,
    @Json(name = "NPR") val NPR: Double = 0.0,
    @Json(name = "CNY") val CNY: Double = 0.0,
    @Json(name = "CHF") val CHF: Double = 0.0,
    @Json(name = "THB") val THB: Double = 0.0,
    @Json(name = "PKR") val PKR: Double = 0.0,
    @Json(name = "KES") val KES: Double = 0.0,
    @Json(name = "EGP") val EGP: Double = 0.0,
    @Json(name = "BDT") val BDT: Double = 0.0,
    @Json(name = "SAR") val SAR: Double = 0.0,
    @Json(name = "LAK") val LAK: Double = 0.0,
    @Json(name = "IDR") val IDR: Double = 0.0,
    @Json(name = "KHR") val KHR: Double = 0.0,
    @Json(name = "SGD") val SGD: Double = 0.0
)

