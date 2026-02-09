# Guía de Uso: ViewModel y Navegación en Jetpack Compose 🚀

Este repositorio es una guía práctica para alumnos de **DAM** sobre cómo implementar la arquitectura **MVVM (Model-View-ViewModel)**, el manejo de estados con `StateFlow` y la navegación segura entre pantallas en Android.

## 📌 ¿Qué aprenderás con este código?

1. **Separación de conceptos:** Lógica de negocio en el ViewModel, UI en Compose.
2. **Gestión de Estados:** Uso de `StateFlow` para una UI reactiva.
3. **Navegación Avanzada:** Paso de argumentos y recuperación de datos en el ViewModel de destino.

---

## 🏗️ Estructura del ViewModel (Encapsulamiento)

Un buen ViewModel protege sus datos para evitar modificaciones accidentales desde la UI. Observa el patrón en `ConverterViewModel.kt` o `CityListWeatherViewModel.kt`:

```kotlin
// 1. Variable privada (Mutable) para cambios internos
private val _celsiusInput = MutableStateFlow("")

// 2. Variable pública (Inmutable) para observación de la UI
val celsiusInput = _celsiusInput.asStateFlow()

```

---

## 🧭 Navegación y Paso de Parámetros

En `AppNavigation.kt`, definimos rutas que aceptan parámetros (como el nombre de la ciudad o la temperatura). Usamos objetos serializables para que la navegación sea robusta:

```kotlin
// Definición del destino con parámetros
@Serializable
data class ClimaDetailDestination(
    val ciudad: String,
    val temperatura: Int
)

// Navegación desde el listado
onCardClick = { ciudad ->
    navController.navigate(ClimaDetailDestination(
        ciudad = ciudad.cityName,
        temperatura = ciudad.temperature
    ))
}

```

---

## 🔍 Recuperar Parámetros en el ViewModel de Detalle

Una de las partes más importantes es cómo la pantalla de detalle (`CityDetailScreen`) obtiene esos datos. En lugar de pasarlos manualmente por el constructor, aprovechamos que **Jetpack Navigation** los guarda en el `SavedStateHandle`.

### 1. El ViewModel de Detalle

En `ClimaDetailViewModel.kt`, recuperamos los datos directamente del `SavedStateHandle`:

```kotlin
class ClimaDetailViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    // Extraemos la ruta para acceder a los argumentos
    private val detailArgs = savedStateHandle.toRoute<ClimaDetailDestination>()

    // Exponemos los datos a la vista
    val cityName = detailArgs.ciudad
    val temperature = detailArgs.temperatura
}

```

### 2. La Pantalla (UI)

La pantalla simplemente pide el ViewModel, y este ya contiene toda la información necesaria:

```kotlin
@Composable
fun CityDetailScreen(
    viewModel: ClimaDetailViewModel = viewModel()
) {
    Text(text = "Ciudad: ${viewModel.cityName}")
    Text(text = "Temperatura: ${viewModel.temperature}º")
}

```

---

## 🛠️ Tecnologías utilizadas

* **Jetpack Compose:** UI declarativa.
* **ViewModel & SavedStateHandle:** Gestión de ciclo de vida y argumentos.
* **StateFlow:** Flujos de datos reactivos.
* **Type-Safe Navigation:** Navegación basada en tipos de Kotlin (Serialization).
