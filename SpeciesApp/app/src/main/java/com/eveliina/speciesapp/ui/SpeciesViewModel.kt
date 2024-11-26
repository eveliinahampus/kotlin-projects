package com.eveliina.speciesapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eveliina.speciesapp.data.model.Species
import com.eveliina.speciesapp.retrofit.RetrofitClient
import kotlinx.coroutines.launch
import retrofit2.HttpException

class SpeciesViewModel : ViewModel() {

    private val gbifService = RetrofitClient.gbifService

    private val _speciesData = MutableLiveData<Species>()
    val speciesData: LiveData<Species> = _speciesData

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun fetchSpeciesData(country: String, type: String) {
        _loading.value = true

        viewModelScope.launch {
            try {
                val response = gbifService.getOccurrenceData(country, type)
                if (response.isSuccessful) {
                    _speciesData.value = response.body()
                } else {
                    _error.value = "Error: ${response.code()}"
                }
            } catch (e: HttpException) {
                _error.value = "HTTP Error: ${e.message()}"
            } catch (e: Exception) {
                _error.value = "Network Error: ${e.message}"
            } finally {
                _loading.value = false
            }
        }
    }
}

