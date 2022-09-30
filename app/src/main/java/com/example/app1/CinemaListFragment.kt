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
        val c1 = Cinema(R.drawable.c1, "Cinemax (Dostyk Plaza) Dolby Atmos", "г. Алматы, Самал-2, д. 111, уг.ул. Жолдасбекова, ТРЦ «Достык Плаза»")
        val c2 = Cinema(R.drawable.c2,"Lumiera Cinema (ЦУМ)", "г. Алматы, пр. Абылай хана, 62, «Арбат»")
        val c3 = Cinema(R.drawable.c3,"Chaplin MEGA Park (ул. Макатаева)", "г. Алматы, ул. Макатаева, 127, 3-й этаж")
        val c4 = Cinema(R.drawable.c4,"Kinopark 11 (Есентай) IMAX", "г. Алматы, пр. Аль-Фараби, 77/8, ТЦ «Esentai Mall»")
        list1.add(c1)
        list1.add(c2)
        list1.add(c3)
        list1.add(c4)
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