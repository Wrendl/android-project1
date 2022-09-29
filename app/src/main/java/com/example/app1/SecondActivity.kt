package com.example.app1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val message = intent.getSerializableExtra(EXTRA_MESSAGE) as? Cinema

        val textView = findViewById<TextView>(R.id.textView2).apply {
            if (message != null) {
                text = message.title
            }
        }
    }
}