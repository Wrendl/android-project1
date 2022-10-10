package com.example.app1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val message = intent.getSerializableExtra(EXTRA_MESSAGE) as? Cinema

        if (message != null) {
            tvCinemaTitle.text = message.title
        }
        if (message != null) {
            imCinemaDetail.setImageResource(message.imageId)
        }
    }
}