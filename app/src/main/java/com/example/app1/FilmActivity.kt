package com.example.app1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_film.*
import kotlinx.android.synthetic.main.activity_second.*

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
    }
}