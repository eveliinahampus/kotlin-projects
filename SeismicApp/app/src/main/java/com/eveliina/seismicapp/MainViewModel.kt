package com.eveliina.seismicapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: SeismicDataRepository) : ViewModel() {

    private val _seismicData = MutableLiveData<SeismicData>()
    val seismicData: LiveData<SeismicData> = _seismicData

    fun loadData() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val data = repository.fetchSeismicData()
                _seismicData.postValue(data)
            } catch (e: Exception) {
                // Handle error
                // You can display an error message or navigate to the error screen
            }
        }
    }
}
