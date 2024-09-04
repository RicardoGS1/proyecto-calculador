package com.virtualworld3d.calculadorfonoma.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.virtualworld3d.calculadorfonoma.navegation.AppNavHost
import com.virtualworld3d.calculadorfonoma.ui.theme.CalculadorFonomaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContent {
            CalculadorFonomaTheme(dynamicColor = false) {
                App()
            }
        }
    }
}

@Composable
fun App()
{
    val modifier: Modifier = Modifier
    Surface(color = MaterialTheme.colorScheme.background) {
        val navController = rememberNavController()
        AppNavHost(
            navController = navController,
            modifier = modifier,
        )
    }
}

