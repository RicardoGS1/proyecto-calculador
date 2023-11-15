package com.example.calculadorfonoma.ui.converter


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.calculadorfonoma.common.NetworkResponseState
import com.example.calculadorfonoma.domain.usecase.GetRatesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.text.DecimalFormat
import javax.inject.Inject

@HiltViewModel
class ConverterViewModel @Inject constructor(private val getRatesUseCase: GetRatesUseCase) : ViewModel()
{

    private val _rates = MutableLiveData<Double>()
    val rates: LiveData<Double> get() = _rates

    private var currencyIn = "USD"
    private var currencyOut = "USD"
    private var currencyValue = 0.0

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
        }
    }


    fun onChangerCurrencyIn(currency: String)
    {
        currencyIn = currency
    }

    fun onChangerCurrencyOut(currency: String)
    {
        currencyOut = currency
    }

    fun onChangerValue(value: String)
    {
        if (value != "")
        {
            val result: Double? = value.toDouble()
            if (result != null) currencyValue = result
        }
    }


}