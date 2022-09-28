package com.example.app1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.cinema_list_fragment.*
import com.example.app1.databinding.CinemaListFragmentBinding

class CinemaListFragment: Fragment() {

    private val args: CinemaListFragmentArgs by navArgs()

    val list1 = ArrayList<Cinema>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val cinema = Cinema(R.drawable.c1, "Cinema 1")
        val cinema1 = Cinema(R.drawable.c3, "Cinema 2")
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
        username_text.text = args.username
        password_text.text = args.password

        rcView.layoutManager = LinearLayoutManager(activity)
        rcView.adapter = context?.let { CinemaAdapter(list1) }
    }
}