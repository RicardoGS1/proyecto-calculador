package com.example.calculadorfonoma.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.calculadorfonoma.navegation.AppNavHost
import com.example.calculadorfonoma.ui.theme.CalculadorFonomaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContent {
            CalculadorFonomaTheme {


                    App()

            }
        }
    }
}

@Composable
fun App()
{
    val modifier: Modifier = Modifier

    Surface(){

        val navController = rememberNavController()

        AppNavHost(
            navController = navController,
            modifier = modifier,

        )

    }


}

