package com.eveliina.bmiviewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class BmiViewModel : ViewModel() {
    var heightInput: String by mutableStateOf("")
    var weightInput: String by mutableStateOf("")
    var bmi: Float by mutableFloatStateOf(0.0f)

    fun updateHeightInput(newHeight: String) {
        heightInput = newHeight.replace(',', '.')
        calculateBMI()
    }

    fun updateWeightInput(newWeight: String) {
        weightInput = newWeight.replace(',', '.')
        calculateBMI()
    }

    private fun calculateBMI() {
        val height = heightInput.toFloatOrNull() ?: 0.0f
        val weight = weightInput.toFloatOrNull() ?: 0.0f
        bmi = if (weight > 0 && height > 0) weight / (height * height) else 0.0f
    }
}
