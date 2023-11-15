package com.example.calculadorfonoma.ui.converter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.calculadorfonoma.common.NetworkResponseState
import com.example.calculadorfonoma.common.ScreenStateProducts
import com.example.calculadorfonoma.domain.entity.RatesEntity
import com.example.calculadorfonoma.domain.usecase.GetRatesUseCase
import com.example.calculadorfonoma.ui.uiData.RatesUiData


import com.virtualworld.tienda_muebles_plastico.domain.mapper.RatesBaseMapper

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat
import javax.inject.Inject

@HiltViewModel
class ConverterViewModel @Inject constructor(private val getRatesUseCase: GetRatesUseCase, private val mapper: RatesBaseMapper<RatesEntity, RatesUiData>) :
    ViewModel()
{

    private val _rates = MutableLiveData<Double>()
    val rates: LiveData<Double> get() = _rates

    var currencyIn = "USD"
    var currencyOut = "USD"
    var currencyValue = 0.0

    fun getRates()
    {
        getRatesUseCase().onEach {
            when (it)
            {
                is NetworkResponseState.Error -> println("error")
                is NetworkResponseState.Loading -> println("loading")
                is NetworkResponseState.Success ->
                {

                    solveConversion(it.result.currencyMap[currencyIn], it.result.currencyMap[currencyOut])


                }
            }
        }.launchIn(viewModelScope)
    }

    private fun solveConversion(d: Double?, d1: Double?)
    {
        if (d != null && d1 != null)
        {

            val result = currencyValue * (d1 / d)

            val df = DecimalFormat("#.##")
            val roundoff = df.format(result)

            _rates.postValue(roundoff.toDouble())
            println(d1 * d1)
        }
    }


    fun onChangerCurrencyIn(currency: String)
    {
        currencyIn = currency
        println(currency)
    }

    fun onChangerCurrencyOut(currency: String)
    {
        currencyOut = currency
        println(currency)
    }

    fun onChangerValue(value: String)
    {

        if (value != "")
        {


            val result: Double? = value.toDouble()

            if (result != null)
            {
                currencyValue = result
            }

        }
        println(value)
    }


    /*
        fun setSelectedRate(value: Double) {
            selectedRate = value
            _forexRate.value = TextFieldValue("1")
            _mmkRate.value = TextFieldValue(value.decimalFormat)
        }
    *//*
    fun updateForexRate(value: TextFieldValue) {

        val formatted = AmountFormat.format(_forexRate.value, value)

        _forexRate.value = formatted

        val input = formatted.text.commasRemoved.toDoubleOrNull()

        _mmkRate.value = if (input == null) TextFieldValue()
        else {
            val result = input * selectedRate
            TextFieldValue(result.decimalFormat)
        }
    }

    fun updateMmkRate(value: TextFieldValue) {

        val formatted = AmountFormat.format(_mmkRate.value, value)

        _mmkRate.value = formatted

        val input = formatted.text.commasRemoved.toDoubleOrNull()

        _forexRate.value = if (input == null) TextFieldValue()
        else {
            val result = input / selectedRate
            TextFieldValue(result.decimalFormat)
        }
    }
    */
}