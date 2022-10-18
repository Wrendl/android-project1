package com.example.app1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app1.data.cinema.Cinema
import com.example.app1.data.session.SessionAdapterCinema
import com.example.app1.main_list.EXTRA_MESSAGE1
import kotlinx.android.synthetic.main.theater_detail.*
import kotlinx.android.synthetic.main.theater_detail.rcView


class CinemaActivity : AppCompatActivity(), SessionAdapterCinema.OnItemClickListener{

    val sessionArr = sessionList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.theater_detail)

        val message = intent.getSerializableExtra(EXTRA_MESSAGE1) as? Cinema

        if (message != null) {
            tvCinemaTitle.text = message.title
            imCinemaDetail.setImageResource(message.imageId)
//            tvCinemaDescription.text = message.description
            tvCinemaAddress.text = message.address
        }

        rcView.layoutManager = LinearLayoutManager(this)
        rcView.adapter = SessionAdapterCinema(sessionArr, this)
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Item $position clicked", Toast.LENGTH_SHORT).show()
//        val clickedItem = cinemaArr[position]
//        val message = cinemaArr[position]
//        val intent = Intent(activity, SecondActivity::class.java).apply{
//            putExtra(EXTRA_MESSAGE, message)
//        }
//        startActivity(intent)
    }
}