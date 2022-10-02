package com.example.app1

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.cinema_list_fragment.*

const val EXTRA_MESSAGE = "com.example.app1.MESSAGE"

class CinemaListFragment: Fragment(), CinemaAdapter.OnItemClickListener {

    val cinemaArr = cinemaList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.cinema_list_fragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rcView.layoutManager = LinearLayoutManager(activity)
        rcView.adapter = context?.let { CinemaAdapter(cinemaArr, this) }
    }

    override fun onItemClick(position: Int) {
//        Toast.makeText(activity, "Item $position clicked", Toast.LENGTH_SHORT).show()
        val clickedItem = cinemaArr[position]
        val message = cinemaArr[position]
        val intent = Intent(activity, SecondActivity::class.java).apply{
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }
}