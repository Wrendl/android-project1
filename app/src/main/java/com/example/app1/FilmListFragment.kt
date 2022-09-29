package com.example.app1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.film_list_fragment.*
import com.example.app1.databinding.FilmListFragmentBinding

class FilmListFragment: Fragment() {

    val list1 = ArrayList<Film>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val film = Film(R.drawable.c1, "Film", "cool", "comedy", 2, listOf("asd", "asd"), 2.8, "16+")
        val film1 = Film(R.drawable.c1, "Film 1", "cool", "comedy", 2, listOf("asd", "asd"), 2.8, "16+")
        list1.add(film)
        list1.add(film1)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.film_list_fragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rcView.layoutManager = LinearLayoutManager(activity)
        rcView.adapter = context?.let { FilmAdapter(list1) }
    }
}