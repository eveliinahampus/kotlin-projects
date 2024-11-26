package com.eveliina.poetryapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PoetryViewModel : ViewModel() {
    private val _poemsLiveData = MutableLiveData<List<Poem>>()
    val poemsLiveData: MutableLiveData<List<Poem>> get() = _poemsLiveData

    private val apiService: PoetryApiService = RetrofitClientInstance.getRetrofitInstance().create(PoetryApiService::class.java)

    fun fetchPoemsByAuthorAndTitle(author: String, title: String) {
        val call = apiService.getPoemsByAuthorAndTitle(author, title)
        call.enqueue(object : Callback<List<Poem>> {
            override fun onResponse(call: Call<List<Poem>>, response: Response<List<Poem>>) {
                if (response.isSuccessful) {
                    _poemsLiveData.value = response.body()
                }
            }

            override fun onFailure(call: Call<List<Poem>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
}


