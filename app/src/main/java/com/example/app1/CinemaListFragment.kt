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

    val list1 = ArrayList<Cinema>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val cinema = Cinema(R.drawable.c1, "Cinema 1", "asd")
        val cinema1 = Cinema(R.drawable.c3, "Cinema 2", "asd")
        list1.add(cinema)
        list1.add(cinema1)
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
        rcView.adapter = context?.let { CinemaAdapter(list1, this) }
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(activity, "Item $position clicked", Toast.LENGTH_SHORT).show()
        val clickedItem = list1[position]
        val message = list1[position]
        val intent = Intent(activity, SecondActivity::class.java).apply{
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }
}