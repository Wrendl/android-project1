package com.example.app1

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.app1.main_list.EXTRA_MESSAGE

class MyTicketsFragment: Fragment() {

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
    }
}