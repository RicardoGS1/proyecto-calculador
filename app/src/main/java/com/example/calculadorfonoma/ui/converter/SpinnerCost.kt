package com.example.calculadorfonoma.ui.converter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


val currencies: List<String> = listOf("USD",
                                      "NZD",
                                      "LKR",
                                      "CZK",
                                      "JPY",
                                      "PHP",
                                      "KRW",
                                      "BRL",
                                      "HKD",
                                      "RSD",
                                      "MYR",
                                      "VND",
                                      "CAD",
                                      "GBP",
                                      "NOK",
                                      "ILS",
                                      "SEK",
                                      "DKK",
                                      "AUD",
                                      "RUB",
                                      "KWD",
                                      "INR",
                                      "BND",
                                      "EUR",
                                      "ZAR",
                                      "NPR",
                                      "CNY",
                                      "CHF",
                                      "THB",
                                      "PKR",
                                      "KES",
                                      "EGP",
                                      "BDT",
                                      "SAR",
                                      "LAK",
                                      "IDR",
                                      "KHR",
                                      "SGD")

@Composable
fun ThemedTaskMenu(onCurrencyType: (String) -> Unit)
{
    var expanded by remember { mutableStateOf(false) }
    var currency by remember { mutableStateOf("USD") }
    onCurrencyType(currency)

    Box() {


        OutlinedButton(
            onClick = { expanded = true },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp, horizontal = 12.dp),
        )

        {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {

                Text(modifier = Modifier, text = currency)

                Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = null, modifier = Modifier.size(ButtonDefaults.IconSize))
            }
        }

        TaskMenu(
            expanded = expanded,
            onItemClick = {
                currency = it
            },
            onDismiss = { expanded = false }, Modifier.align(Alignment.BottomStart),
        )

    }
}


@Composable
fun TaskMenu(
    expanded: Boolean,
    onItemClick: (String) -> Unit, onDismiss: () -> Unit, modifier: Modifier,
)
{

    Box(modifier = modifier) {
        DropdownMenu(
            modifier = Modifier
                .height(500.dp)
                .width(160.dp)
                .padding(horizontal = 24.dp),
            expanded = expanded,
            onDismissRequest = onDismiss,

            ) {
            currencies.forEach { item ->
                DropdownMenuItem(text = { Text(text = item) }, onClick = {
                    onItemClick(item)
                    onDismiss()
                })
            }
        }
    }
}