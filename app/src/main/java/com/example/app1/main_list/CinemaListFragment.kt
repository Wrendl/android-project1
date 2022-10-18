package com.example.app1.main_list

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app1.CinemaActivity
import com.example.app1.R
import com.example.app1.cinemaList
import com.example.app1.data.cinema.CinemaAdapter
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
        val intent = Intent(activity, CinemaActivity::class.java).apply{
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }
}