package com.example.app1.auth

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.app1.R
import com.example.app1.data.user.UserViewModel
import kotlinx.android.synthetic.main.login_fragment.*
import kotlinx.android.synthetic.main.profile_fragment.*

class LoginFragment: Fragment(R.layout.login_fragment) {

    private lateinit var mUserViewModel: UserViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_confirm.setOnClickListener {
            val login = edit_text_username.text.toString()
            val password = edit_text_password.text.toString()

            //Check emptiness
            if (login.trim().isEmpty() && password.trim().isEmpty()) {
                Toast.makeText(activity, "Input required", Toast.LENGTH_LONG).show()
            }

            //TODO Check existing account
            else if (checkExistAccount(login)) {
                Toast.makeText(activity, "No such account", Toast.LENGTH_LONG).show()
            }

            //TODO Check password
            else if (checkPassword(login, password)) {
                Toast.makeText(activity, "Incorrect password", Toast.LENGTH_LONG).show()
            }

            else {
                val action = LoginFragmentDirections.actionLoginFragmentToProfileFragment(login)
                findNavController().navigate(action)
            }
        }

        button_register.setOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragmentToRegistrationFragment()
            findNavController().navigate(action)
        }
    }

    private fun checkPassword(login: String, password: String): Boolean {
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        val dbPassw = mUserViewModel.getUserByLogin(login).password

        if (dbPassw != password) {
            return true
        }
        return false
    }

    private fun checkExistAccount(login: String): Boolean {
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        try {
            mUserViewModel.getUserByLogin(login).login
            return false
        }
        catch (e: Exception) {
            return true
        }
    }
}