package com.example.app1.main_list

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app1.FilmActivity
import com.example.app1.R
import com.example.app1.data.film.FilmAdapter
import com.example.app1.filmList
import kotlinx.android.synthetic.main.film_list_fragment.*


const val EXTRA_MESSAGE1 = "com.example.app1.MESSAGE"

class FilmListFragment: Fragment(), FilmAdapter.OnItemClickListener {

    val filmArr = filmList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        rcView.adapter = context?.let { FilmAdapter(filmArr, this) }
    }

    override fun onItemClick(position: Int) {
//        Toast.makeText(activity, "Item $position clicked", Toast.LENGTH_SHORT).show()
        val clickedItem = filmArr[position]
        val message = filmArr[position]
        val intent = Intent(activity, FilmActivity::class.java).apply{
            putExtra(EXTRA_MESSAGE1, message)
        }
        startActivity(intent)
    }
}