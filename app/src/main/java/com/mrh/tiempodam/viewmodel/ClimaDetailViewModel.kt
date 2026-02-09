package com.mrh.tiempodam.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import com.mrh.tiempodam.ClimaDetailDestination
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ClimaDetailViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    // PRIMERO RECOGER LOS ARGUMENTOS DE FORMA SEGURA USANDO toRoute
    private val routeArgs = savedStateHandle.toRoute<ClimaDetailDestination>()

    private val _cityName = MutableStateFlow(routeArgs.ciudad)
    val cityName = _cityName.asStateFlow()

    private val _temperature = MutableStateFlow(routeArgs.temperatura)
    val temperature = _temperature.asStateFlow()


    // Carga de datos desde una API...
    /*
    init{

    }
     */

}