package com.example.app1.data.session

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import com.example.app1.R
import com.example.app1.databinding.SessionItemForCinemaBinding


class SessionAdapterCinema(val sessionList: ArrayList<Session>, private val listener: OnItemClickListener): RecyclerView.Adapter<SessionAdapterCinema.SessionHolderCinema>() {

    inner class SessionHolderCinema(item: View): RecyclerView.ViewHolder(item),  View.OnClickListener{
        val binding = SessionItemForCinemaBinding.bind(item)
        fun bind(session: Session) = with(binding){
            tvSessionTime.text = session.time
            tvSessionFilmTitle.text = session.filmTitle
            sessionLanguage.text = session.language
            priceChild.text = session.priceChild
            priceAdult.text = session.priceAdult
            priceStudent.text = session.priceStud
            priceVip.text = session.priceVip
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SessionHolderCinema {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.session_item_for_cinema, parent, false)
        return SessionHolderCinema(view)
    }

    override fun onBindViewHolder(holder: SessionHolderCinema, position: Int) {
        holder.bind(sessionList[position])
    }

    override fun getItemCount(): Int {
        return sessionList.size
    }

    fun addCinema(session: Session) {
        sessionList.add(session)
    }
}