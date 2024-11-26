package com.eveliina.speciesapp.ui

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.eveliina.speciesapp.R
import com.eveliina.speciesapp.data.model.Species
import com.eveliina.speciesapp.retrofit.RetrofitClient
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var speciesTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        speciesTextView = findViewById(R.id.speciesTextView)

        fetchData()
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun fetchData() {
        val service = RetrofitClient.create().getOccurrenceData()
        GlobalScope.launch(Dispatchers.Main) {
            try {
                val species = service.execute().body()
                updateUI(species)
            } catch (e: Exception) {
                handleFetchError()
            }
        }
    }

    private fun updateUI(species: Species?) {
        if (species != null) {
            val speciesData = buildSpeciesDataString(species)
            speciesTextView.text = speciesData
        } else {
            speciesTextView.text = getString(R.string.error_message_default)
        }
    }

    private fun buildSpeciesDataString(species: Species): String {
        val stringBuilder = StringBuilder()
        stringBuilder.append("Name: ${species.name}\n")
        stringBuilder.append("Kingdom: ${species.kingdom}\n")
        stringBuilder.append("Phylum: ${species.phylum}\n")
        stringBuilder.append("Class: ${species.clazz}\n")
        stringBuilder.append("Order: ${species.order}\n")
        stringBuilder.append("Family: ${species.family}\n")
        stringBuilder.append("Genus: ${species.genus}\n")
        species.imageUrl?.let { stringBuilder.append("Image URL: $it\n") }
        return stringBuilder.toString()
    }

    private fun handleFetchError() {
        Toast.makeText(this, R.string.network_error_message, Toast.LENGTH_SHORT).show()
    }
}

