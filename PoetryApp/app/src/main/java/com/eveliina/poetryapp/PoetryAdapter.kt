package com.eveliina.poetryapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PoetryAdapter(private val poems: List<Poem>) : RecyclerView.Adapter<PoetryAdapter.PoemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PoemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_poem, parent, false)
        return PoemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PoemViewHolder, position: Int) {
        val poem = poems[position]
        holder.bind(poem)
    }

    override fun getItemCount(): Int {
        return poems.size
    }

    class PoemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.textViewTitle)
        private val authorTextView: TextView = itemView.findViewById(R.id.textViewAuthor)

        fun bind(poem: Poem) {
            titleTextView.text = poem.title
            authorTextView.text = poem.author
        }
    }
}
