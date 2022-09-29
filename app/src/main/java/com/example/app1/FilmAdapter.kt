package com.example.app1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app1.databinding.FilmItemBinding

class FilmAdapter(val filmList: ArrayList<Film>): RecyclerView.Adapter<FilmAdapter.FilmHolder>() {

    class FilmHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = FilmItemBinding.bind(item)
        fun bind(film: Film) = with(binding){
            imFilm.setImageResource(film.imageId)
            tvFilm.text = film.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.film_item, parent, false)
        return FilmHolder(view)
    }

    override fun onBindViewHolder(holder: FilmHolder, position: Int) {
        holder.bind(filmList[position])
    }

    override fun getItemCount(): Int {
        return filmList.size
    }

    fun addCinema(film: Film) {
        filmList.add(film)
    }
}