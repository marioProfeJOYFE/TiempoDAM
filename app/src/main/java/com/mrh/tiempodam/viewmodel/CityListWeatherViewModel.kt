package com.mrh.tiempodam.viewmodel

import androidx.lifecycle.ViewModel
import com.mrh.tiempodam.model.WeatherCity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CityListWeatherViewModel : ViewModel() {

    private val _cityList = MutableStateFlow<List<WeatherCity>>(listOf(
        WeatherCity(
            cityName = "Madrid",
            temperature = 20.0
        ),
        WeatherCity(
            cityName = "Barcelona",
            temperature = 15.0
        ),
        WeatherCity(
            cityName = "Alicante",
            temperature = 25.0
        ),
    ))

    val cityList = _cityList.asStateFlow()


    //Constructor (por si lo necesitais en el futuro)
    init {

    }

}