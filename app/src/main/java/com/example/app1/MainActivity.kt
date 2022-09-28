package com.example.app1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val adapter = CinemaAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
//        setContentView(R.layout.activity_main)
    }

    private fun init() {
        binding.apply {
            rcView.layoutManager = LinearLayoutManager(this@MainActivity)
            val cinema = Cinema(R.drawable.c1, "Cinema 1")
            val cinema1 = Cinema(R.drawable.c3, "Cinema 2")
//            adapter.addCinema(cinema)
//            adapter.addCinema(cinema1)
            rcView.adapter = adapter
        }
    }
}