package com.example.app1

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.login_fragment.*

class LoginFragment: Fragment(R.layout.login_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_confirm.setOnClickListener {
            val username = edit_text_username.text.toString()
            val password = edit_text_password.text.toString()

            val action = LoginFragmentDirections.actionLoginFragmentToCinemaListFragment(username, password)
            findNavController().navigate(action)
        }
    }
}