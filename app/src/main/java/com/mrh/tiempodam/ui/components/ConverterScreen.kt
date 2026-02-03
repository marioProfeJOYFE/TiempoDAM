package com.mrh.tiempodam.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mrh.tiempodam.viewmodel.ConverterViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConverterScreen(
    // SI YA EXISTE, LO RECUPERA SOLO, SINO LO CREA
    viewModel: ConverterViewModel = viewModel(),
    onButtonClick: () -> Unit
){
    // Observar las variables del viewModel
    val input by viewModel.celsiusInput.collectAsState()
    val result by viewModel.fahrenheitResult.collectAsState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Conversor de Temperatura")
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding).fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            OutlinedTextField(
                value = input,
                onValueChange = { textoUsuario ->
                    if(textoUsuario.isDigitsOnly())
                    viewModel.onCelsiusChange(textoUsuario)
                },
                label = {
                    Text("Grados Celsius")
                },
                keyboardOptions = KeyboardOptions( keyboardType = KeyboardType.Decimal)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Resultado: $result ºF",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = onButtonClick
            ){
                Text("Ir a Otra Ventana")
            }
        }
    }

}