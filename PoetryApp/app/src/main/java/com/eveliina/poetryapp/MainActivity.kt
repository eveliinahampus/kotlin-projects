package com.eveliina.poetryapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView

@Suppress("RedundantSamConstructor", "ReplaceWithIndexing")
class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: PoetryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[PoetryViewModel::class.java]

        // Call fetchPoemsByAuthorAndTitle with author and title values
        viewModel.fetchPoemsByAuthorAndTitle("Shakespeare", "Sonnet")

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        // Observe LiveData for changes and update UI accordingly
        viewModel.poemsLiveData.observe(this, Observer { poems ->
            // Update the RecyclerView adapter with the new list of poems
            val adapter = PoetryAdapter(poems)
            recyclerView.adapter = adapter
        })
    }
}
