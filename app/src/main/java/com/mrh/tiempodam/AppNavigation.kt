package com.mrh.tiempodam

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mrh.tiempodam.ui.components.ConverterScreen
import kotlinx.serialization.Serializable

@Serializable
object ConversorTemperaturaDestination


@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        startDestination = ConversorTemperaturaDestination,
        navController = navController
    ) {
        composable<ConversorTemperaturaDestination>{
            ConverterScreen()
        }
    }
}