package com.example.app1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app1.databinding.CinemaItemBinding

class CinemaAdapter: RecyclerView.Adapter<CinemaAdapter.CinemaHolder>() {
    val plantList = ArrayList<Cinema>()

    class CinemaHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = CinemaItemBinding.bind(item)
        fun bind(cinema: Cinema) = with(binding){
            imCinema.setImageResource(cinema.imageId)
            tvCinema.text = cinema.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CinemaHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cinema_item, parent, false)
        return CinemaHolder(view)
    }

    override fun onBindViewHolder(holder: CinemaHolder, position: Int) {
        holder.bind(plantList[position])
    }

    override fun getItemCount(): Int {
        return plantList.size
    }

    fun addCinema(cinema: Cinema) {
        plantList.add(cinema)
    }
}