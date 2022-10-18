package com.example.app1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app1.data.film.Film
import com.example.app1.data.session.Session
import com.example.app1.data.session.SessionAdapter
import com.example.app1.main_list.EXTRA_MESSAGE
import kotlinx.android.synthetic.main.film_detail.*
import kotlinx.android.synthetic.main.film_detail.rcView
import com.example.app1.sessionList

class FilmActivity : AppCompatActivity(), SessionAdapter.OnItemClickListener{

    val sessionArr = sessionList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.film_detail)

        val film = intent.getSerializableExtra(EXTRA_MESSAGE) as? Film

        if (film != null) {
            tvFilmTitle.text = film.title
            imFilmDetail.setImageResource(film.imageId)
            tvFilmDescription.text = film.description
            tvFilmTimeDuration.text = film.timeDuration
            tvFilmActors.text = film.actors
            tvFilmRating.text = (film.rating).toString()
//            tvFilmAgeLimit.text = film.ageLimit
        }


        rcView.layoutManager = LinearLayoutManager(this)
        rcView.adapter = SessionAdapter(sessionArr, this)
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