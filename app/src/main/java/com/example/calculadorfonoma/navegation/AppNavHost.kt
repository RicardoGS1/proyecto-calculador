package com.example.calculadorfonoma.navegation // ktlint-disable package-name

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hlayan.forexrate.ui.converter.ConverterRoute
import com.hlayan.forexrate.ui.converter.ConverterViewModel


@Composable
fun AppNavHost(navController: NavHostController, modifier: Modifier = Modifier)
{

    NavHost(navController = navController, startDestination = Converter.route, modifier = modifier) {


        composable(Converter.route) {
                val viewModel = hiltViewModel<ConverterViewModel>()
                ConverterRoute(viewModel)

        }




    }
}
