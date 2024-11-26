package com.eveliina.seismicapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.eveliina.seismicapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        observeSeismicData()
    }

    private fun observeSeismicData() {
        viewModel.seismicData.observe(this) { seismicData ->
            // Update UI with seismic data visualization
            // You can use a custom view or a chart library for visualization
            // Example: binding.seismicDataView.updateData(seismicData)
        }

        viewModel.loadData() // Fetch seismic data when activity is created
    }
}
