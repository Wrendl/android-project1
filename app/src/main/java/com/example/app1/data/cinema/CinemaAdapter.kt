package com.example.app1.data.cinema

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app1.R
import com.example.app1.databinding.CinemaItemBinding

class CinemaAdapter(val cinemaList: ArrayList<Cinema>, private val listener: OnItemClickListener): RecyclerView.Adapter<CinemaAdapter.CinemaHolder>() {

    inner class CinemaHolder(item: View): RecyclerView.ViewHolder(item),  View.OnClickListener{
        val binding = CinemaItemBinding.bind(item)
        fun bind(cinema: Cinema) = with(binding){
            imCinema.setImageResource(cinema.imageId)
            tvCinema.text = cinema.title
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CinemaHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cinema_item, parent, false)
        return CinemaHolder(view)
    }

    override fun onBindViewHolder(holder: CinemaHolder, position: Int) {
        holder.bind(cinemaList[position])
    }

    override fun getItemCount(): Int {
        return cinemaList.size
    }

    fun addCinema(cinema: Cinema) {
        cinemaList.add(cinema)
    }
}