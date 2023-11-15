package com.example.calculadorfonoma.ui.converter

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val lightBlue = Color(0xFFECEFF8)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldCost(enabledEdit: Boolean, onCurrencyValue: (String) -> Unit, ratesState: Double?)
{

    var numberCurrency by remember { mutableStateOf("") }



    onCurrencyValue(numberCurrency)


    OutlinedTextField(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp),
                      value = ratesState?.toString() ?: numberCurrency,

                      onValueChange = {

                              numberCurrency=ValidarNumeroDecimal(it)
                      },
                      shape = RoundedCornerShape(30.dp),
                      enabled = enabledEdit,
                      textStyle = LocalTextStyle.current.copy(fontSize = 18.sp),
                      keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                      singleLine = true,
                      colors = TextFieldDefaults.textFieldColors(containerColor = lightBlue,
                                                                 cursorColor = Color.Black,
                                                                 focusedIndicatorColor = Color.Transparent,
                                                                 unfocusedIndicatorColor = Color.Transparent),
                      trailingIcon = {
                          if (numberCurrency.isNotEmpty())
                          {
                              IconButton(onClick = { numberCurrency="" }) {
                                  Icon(imageVector = Icons.Outlined.Close, contentDescription = null)
                              }
                          }
                      })
}

fun ValidarNumeroDecimal(preCurrency:String) : String {

    val filteredChars = preCurrency.filterIndexed {
            index, c -> c in "0123456789" ||   (c == '.' && preCurrency.indexOf('.') == index)
    }


    return filteredChars
}







