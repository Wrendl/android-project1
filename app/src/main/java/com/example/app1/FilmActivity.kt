package com.example.app1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_film.*

class FilmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film)

        val film = intent.getSerializableExtra(EXTRA_MESSAGE) as? Film

        if (film != null) {
            tvFilmTitle.text = film.title
        }
        if (film != null) {
            imFilmDetail.setImageResource(film.imageId)
        }
        if (film != null) {
            tvFilmDescription.text = film.description
        }
        if (film != null) {
            tvFilmTimeDuration.text = film.timeDuration
        }
        if (film != null) {
            tvFilmActors.text = film.actors
        }
        if (film != null) {
            tvFilmRating.text = (film.rating).toString()
        }
        if (film != null) {
            tvFilmAgeLimit.text = film.ageLimit
        }
    }
}