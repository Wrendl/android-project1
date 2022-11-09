package com.example.app1.data.session

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import com.example.app1.R
import com.example.app1.databinding.SessionItemFilmBinding
import kotlinx.android.synthetic.main.session_item_film.view.*


class SessionAdapter(val sessionList: ArrayList<Session>, private val listener: OnItemClickListener): RecyclerView.Adapter<SessionAdapter.SessionHolder>() {

    inner class SessionHolder(item: View): RecyclerView.ViewHolder(item),  View.OnClickListener{
        val binding = SessionItemFilmBinding.bind(item)
        fun bind(session: Session) = with(binding){
            tvSessionTime.text = session.time
            tvSessionCinemaTitle.text = session.cinemaTitle
            sessionLanguage.text = session.language
            priceAdult.text = session.priceAdult
            priceChild.text = session.priceChild
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SessionHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.session_item_film, parent, false)
        return SessionHolder(view)
    }

    override fun onBindViewHolder(holder: SessionHolder, position: Int) {
        holder.bind(sessionList[position])
    }

    override fun getItemCount(): Int {
        return sessionList.size
    }

    fun addCinema(session: Session) {
        sessionList.add(session)
    }
}