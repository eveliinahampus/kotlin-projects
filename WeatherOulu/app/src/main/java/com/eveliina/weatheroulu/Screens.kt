package com.eveliina.weatheroulu

import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@Composable
fun WeatherScreen(viewModel: WeatherViewModel) {
    val weatherData = viewModel.weatherData.value
    val loading = viewModel.loading.value
    val error = viewModel.error.value

    // Fetch weather data when the screen is first displayed
    LaunchedEffect(Unit) {
        viewModel.fetchWeather()
    }

    // Display loading spinner if data is loading
    if (loading!!) {
        CircularProgressIndicator(modifier = Modifier.size(48.dp))
    } else {
        // Display weather data or error message
        weatherData?.let {
            Text(text = "Temperature: $it°C", fontSize = 24.sp)
        }
        error?.let {
            Text(text = "Error: $it", fontSize = 24.sp)
        }
    }
}




@Composable
fun InfoScreen() {
    // Implement Info UI here
}
