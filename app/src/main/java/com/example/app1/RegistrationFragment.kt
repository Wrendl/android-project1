package com.example.app1

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.register_fragment.*

class RegistrationFragment: Fragment(R.layout.register_fragment) {

    private val args: ProfileFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_register.setOnClickListener {

            if (edit_text_username.text.trim().isNotEmpty() ||
                edit_text_mail.text.trim().isNotEmpty() ||
                edit_text_password.text.trim().isNotEmpty() ||
                edit_text_password_confirm.text.trim().isNotEmpty()) {

            }else {
                Toast.makeText(activity, "Input required", Toast.LENGTH_LONG).show()
            }

        }

        button_to_login.setOnClickListener {
            val action = RegistrationFragmentDirections.actionRegistrationFragmentToLoginFragment()
            findNavController().navigate(action)
        }

    }
}