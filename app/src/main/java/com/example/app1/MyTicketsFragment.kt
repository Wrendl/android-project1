package com.example.app1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app1.data.film.FilmAdapter
import com.example.app1.data.tickets.Tickets
import com.example.app1.data.tickets.TicketsAdapter
import kotlinx.android.synthetic.main.film_list_fragment.*

class MyTicketsFragment: Fragment(), FilmAdapter.OnItemClickListener  {

    var listOfTickets = getMyTickets()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (getActiveUser() != null) {
            return inflater.inflate(R.layout.my_tickets_fragment, container, false)
        } else {
            return inflater.inflate(R.layout.my_tickets_fragment_error, container, false)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (getActiveUser() != null) {

            rcView.layoutManager = LinearLayoutManager(activity)
            rcView.adapter = context?.let { TicketsAdapter(listOfTickets, this) }






        }
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(activity, "Item $position clicked", Toast.LENGTH_SHORT).show()
    }
}