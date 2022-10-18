package com.example.app1.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.app1.R
import com.example.app1.data.user.User
import com.example.app1.data.user.UserViewModel
import kotlinx.android.synthetic.main.register_fragment.*

class RegistrationFragment: Fragment(R.layout.register_fragment) {

    private lateinit var mUserViewModel: UserViewModel

    private fun insertDataToDatabase() {

        val login = edit_text_username.text
        val mail = edit_text_mail.text
        val firstPassword = edit_text_password.text
        val secondPassword = edit_text_password_confirm.text

        if (login.trim().isEmpty() && mail.trim().isEmpty() &&
            firstPassword.trim().isEmpty() && secondPassword.trim().isEmpty()) {
            Toast.makeText(activity, "Input required", Toast.LENGTH_LONG).show()
        }
        else if (firstPassword.toString() != secondPassword.toString()) {
            Toast.makeText(activity, "Passwords don't match", Toast.LENGTH_LONG).show()
        }
        else if (checkExistAccount(login.toString())) {
            Toast.makeText(activity, "Account already exist", Toast.LENGTH_LONG).show()
        }
        else {
            val user = User(0, login.toString(), firstPassword.toString(), mail.toString())
            mUserViewModel.addUser(user)

            Toast.makeText(activity, "Good", Toast.LENGTH_LONG).show()

            val action = RegistrationFragmentDirections.actionRegistrationFragmentToProfileFragment(login.toString())
            findNavController().navigate(action)
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        button_register.setOnClickListener {
            insertDataToDatabase()
        }

        button_to_login.setOnClickListener {
            val action = RegistrationFragmentDirections.actionRegistrationFragmentToLoginFragment()
            findNavController().navigate(action)
        }
    }

    private fun checkExistAccount(login: String): Boolean {
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        try {
            mUserViewModel.getUserByLogin(login).login
            return true
        }
        catch (e: Exception) {
            return false
        }
    }
}