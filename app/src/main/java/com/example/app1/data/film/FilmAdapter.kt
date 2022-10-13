package com.example.app1.data.film

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app1.R
import com.example.app1.databinding.FilmItemBinding

class FilmAdapter(val filmList: ArrayList<Film>, private val listener: OnItemClickListener):
    RecyclerView.Adapter<FilmAdapter.FilmHolder>() {

    inner class FilmHolder(item: View): RecyclerView.ViewHolder(item),   View.OnClickListener {
        val binding = FilmItemBinding.bind(item)
        fun bind(film: Film) = with(binding){
            imFilm.setImageResource(film.imageId)
            tvFilm.text = film.title
        }

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
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