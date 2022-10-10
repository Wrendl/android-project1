package com.example.app1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.login_fragment.*

class LoginFragment: Fragment(R.layout.login_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_confirm.setOnClickListener {

            if (edit_text_username.text.trim().isNotEmpty() || edit_text_password.text.trim().isNotEmpty()) {
                val username = edit_text_username.text.toString()
                val password = edit_text_password.text.toString()

                val action = LoginFragmentDirections.actionLoginFragmentToProfileFragment(username)
                findNavController().navigate(action)
            }
            else {
                Toast.makeText(activity, "Input required", Toast.LENGTH_LONG).show()
            }
        }

        button_register.setOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragmentToRegistrationFragment()
            findNavController().navigate(action)
        }
    }
}