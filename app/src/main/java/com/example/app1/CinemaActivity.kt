package com.example.app1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app1.data.cinema.Cinema
import com.example.app1.data.session.SessionAdapterCinema
import com.example.app1.main_list.EXTRA_MESSAGE1
import com.ms.square.android.expandabletextview.ExpandableTextView
import kotlinx.android.synthetic.main.film_detail.*
import kotlinx.android.synthetic.main.theater_detail.*
import kotlinx.android.synthetic.main.theater_detail.expand_text_view
import kotlinx.android.synthetic.main.theater_detail.rcView


class CinemaActivity : AppCompatActivity(), SessionAdapterCinema.OnItemClickListener{


    var sessionList = sessionList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.theater_detail)

        val cinema = intent.getSerializableExtra(EXTRA_MESSAGE1) as? Cinema

        if (cinema != null) {
            tvCinemaTitle.text = cinema.title
            imCinemaDetail.setImageResource(cinema.imageId)
//            tvCinemaDescription.text = message.description
            tvCinemaAddress.text = cinema.address

            val sessionArr = sessionForCinema(cinema.id)
            sessionList = sessionArr

            val expTv: ExpandableTextView = expand_text_view
            expTv.text = cinema.description

            rcView.layoutManager = LinearLayoutManager(this)
            rcView.adapter = SessionAdapterCinema(sessionArr, this)
        }

    }

    override fun onItemClick(position: Int) {
//        Toast.makeText(this, "Item $position clicked", Toast.LENGTH_SHORT).show()
//        val clickedItem = cinemaArr[position]
        val message = sessionList[position]
        val intent = Intent(this, SessionActivity::class.java).apply{
            putExtra(EXTRA_MESSAGE1, message)
        }
        startActivity(intent)
    }
}