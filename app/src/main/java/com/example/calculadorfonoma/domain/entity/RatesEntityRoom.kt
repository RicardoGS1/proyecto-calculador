package com.example.calculadorfonoma.domain.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "rates")
data class RatesEntityRoom(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "rates_id")
    val ratesId: Int,

    @ColumnInfo(name = "currency_name")
    val currencyName: String,

    @ColumnInfo(name = "rate_value")
    val rateValue: Double,

    )