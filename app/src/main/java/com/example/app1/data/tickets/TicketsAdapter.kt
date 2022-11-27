package com.example.app1.data.tickets

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import com.example.app1.MyTicketsFragment
import com.example.app1.R
import com.example.app1.databinding.MyTicketsItemBinding
import kotlinx.android.synthetic.main.my_tickets_item.view.*


class TicketsAdapter(val ticketsList: ArrayList<Tickets>, private val listener: MyTicketsFragment): RecyclerView.Adapter<TicketsAdapter.SessionHolder>() {

    inner class SessionHolder(item: View): RecyclerView.ViewHolder(item),  View.OnClickListener{
        val binding = MyTicketsItemBinding.bind(item)
        fun bind(tickets: Tickets) = with(binding){
            imFilmMyTickets.setImageResource(tickets.filmImageId)
            tvFilmMyTickets.text = tickets.session.filmTitle
            tvCinemaMyTickets.text = tickets.session.cinemaTitle
            tvTimeMyTickets.text = tickets.session.time
            tvTypeMyTickets.text = tickets.typeOfTicket
            tvRowIdMyTickets.text = tickets.rowId.toString()
            tvColumnIdMyTickets.text = tickets.columnId.toString()
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SessionHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.my_tickets_item, parent, false)
        return SessionHolder(view)
    }

    override fun onBindViewHolder(holder: SessionHolder, position: Int) {
        holder.bind(ticketsList[position])
    }

    override fun getItemCount(): Int {
        return ticketsList.size
    }
}