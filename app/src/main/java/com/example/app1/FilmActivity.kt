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
import com.ms.square.android.expandabletextview.ExpandableTextView

class FilmActivity : AppCompatActivity(), SessionAdapter.OnItemClickListener{

    var sessionList = sessionList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.film_detail)

        val film = intent.getSerializableExtra(EXTRA_MESSAGE) as? Film

        if (film != null) {
            tvFilmTitle.text = film.title
            imFilmDetail.setImageResource(film.imageId)
//            tvFilmDescription.text = film.description
            tvFilmTimeDuration.text = film.timeDuration
            tvFilmActors.text = film.actors
            tvFilmRating.text = (film.rating).toString()
//            tvFilmAgeLimit.text = film.ageLimit
            tvFilmGenres.text = film.genre

            val expTv: ExpandableTextView = expand_text_view
            expTv.text = film.description

            val sessionArr = sessionForFilm(film.id)
            sessionList = sessionArr

            rcView.layoutManager = LinearLayoutManager(this)
            rcView.adapter = SessionAdapter(sessionArr, this)
        }
    }

    override fun onItemClick(position: Int) {
        if (getActiveUser() != null) {
            val message = sessionList[position]
            val intent = Intent(this, SessionActivity::class.java).apply {
                putExtra(EXTRA_MESSAGE, message)
            }
            startActivity(intent)
        }else {
            Toast.makeText(this, "You are unauthorized", Toast.LENGTH_SHORT).show()
        }
    }
}