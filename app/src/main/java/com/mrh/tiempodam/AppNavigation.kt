package com.mrh.tiempodam

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.mrh.tiempodam.ui.components.CityDetailScreen
import com.mrh.tiempodam.ui.components.CityListWeatherScreen
import com.mrh.tiempodam.ui.components.ConverterScreen
import kotlinx.serialization.Serializable

@Serializable
object ConversorTemperaturaDestination

@Serializable
object ListadoCiudadesClimaDestination

@Serializable
data class ClimaDetailDestination(
    val ciudad: String,
    val temperatura: Double
)


@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        startDestination = ListadoCiudadesClimaDestination,
        navController = navController
    ) {
        composable<ConversorTemperaturaDestination>{
            ConverterScreen(
                onButtonClick = {
                    navController.navigate(ListadoCiudadesClimaDestination)
                }
            )
        }
        composable<ListadoCiudadesClimaDestination>{
            CityListWeatherScreen(onCardClick = { ciudadSeleccionada ->
                navController.navigate(ClimaDetailDestination(
                    ciudad = ciudadSeleccionada.cityName,
                    temperatura = ciudadSeleccionada.temperature
                ))
            })
        }
        composable<ClimaDetailDestination>{
            CityDetailScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}