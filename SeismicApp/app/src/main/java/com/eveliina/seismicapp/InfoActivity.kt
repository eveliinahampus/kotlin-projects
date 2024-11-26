package com.eveliina.seismicapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.eveliina.seismicapp.databinding.ActivityInfoBinding

class InfoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize UI components and display information about the app
    }
}
