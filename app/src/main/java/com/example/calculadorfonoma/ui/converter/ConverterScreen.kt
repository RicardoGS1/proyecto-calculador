package com.hlayan.forexrate.ui.converter

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.tooling.preview.Preview


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ConverterRoute(viewModel: ConverterViewModel)
{

   // LaunchedEffect(currency) { viewModel.setSelectedRate(currency.rate) }
/*
    Surface(modifier) {
        Column {
            TopAppBar(
                title = { Text(text = "Converter") },
                navigationIcon = {
                    val keyboardController = LocalSoftwareKeyboardController.current
                    IconButton(onClick = {
                        keyboardController?.hide()
                        onNavigateUp()
                    }) {
                        Icon(Icons.Filled.ArrowBack, "Navigate up")
                    }
                },
                backgroundColor = MaterialTheme.colors.surface,
                contentColor = MaterialTheme.colors.onSurface,
                elevation = 0.dp
            )
            Divider()

            LazyColumn(
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                item {
                    CurrencyField(
                        value = viewModel.forexRate.value,
                        labelText = currency.run { "$name $flagEmoji" },
                        placeholderText = currency.name,
                        onValueChange = viewModel::updateForexRate
                    )
                }

                item {
                    CurrencyField(
                        value = viewModel.mmkRate.value,
                        onValueChange = viewModel::updateMmkRate
                    )
                }
            }
        }
    }
*/

    /*
    BackHandler { onNavigateUp() }
    */

}

//private const val floatingPattern = "([0-9]{0,16}([.][0-9]{0,2})?)"

