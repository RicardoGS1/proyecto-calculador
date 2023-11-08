package com.hlayan.forexrate.ui.converter

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ConverterViewModel @Inject constructor() : ViewModel() {

    private val _forexRate = mutableStateOf(TextFieldValue())
    val forexRate: State<TextFieldValue> get() = _forexRate

    private val _mmkRate = mutableStateOf(TextFieldValue())
    val mmkRate: State<TextFieldValue> get() = _mmkRate

    private var selectedRate = 0.0
/*
    fun setSelectedRate(value: Double) {
        selectedRate = value
        _forexRate.value = TextFieldValue("1")
        _mmkRate.value = TextFieldValue(value.decimalFormat)
    }
*/
  /*
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