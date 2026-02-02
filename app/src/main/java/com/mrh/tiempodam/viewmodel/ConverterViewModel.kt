package com.mrh.tiempodam.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ConverterViewModel : ViewModel() {
    // El input del usuario
    // Variable privada dentro del ViewModel que se puede modificar
    private val _celsiusInput = MutableStateFlow("")
    // Versión pública e INMUTABLE que la UI escucha
    val celsiusInput = _celsiusInput.asStateFlow()

    // Guardamos el resultado del calculo
    private val _fahrenheitResult = MutableStateFlow(0.0)
    val fahrenheitResult = _fahrenheitResult.asStateFlow()

    fun onCelsiusChange(newInput: String){
        _celsiusInput.value = newInput
        convert(newInput)
    }

    private fun convert(input: String){
        val celsius = input.toDoubleOrNull()
        if (celsius != null){
            _fahrenheitResult.value = (celsius * 1.8) + 32
        }else{
            _fahrenheitResult.value = 0.0
        }
    }

}