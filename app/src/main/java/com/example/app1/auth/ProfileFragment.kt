package com.example.app1.auth

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.app1.R
import com.example.app1.changeUser
import com.example.app1.data.user.UserViewModel
import com.example.app1.getActiveUser
import kotlinx.android.synthetic.main.profile_fragment.*

class ProfileFragment: Fragment(R.layout.profile_fragment) {

    private lateinit var mUserViewModel: UserViewModel
    private val args: ProfileFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        val user = mUserViewModel.getUserByLogin(args.login)

        changeUser(user)

        val userActive = getActiveUser()

        if (userActive != null) {
            username_text.text = userActive.login
            user_cash.text = userActive.money.toString()


            button_add_cash.setOnClickListener() {
                mUserViewModel.addCash(userActive.login)
                activity?.recreate()
            }

            button_delete_cash.setOnClickListener() {
                mUserViewModel.deleteCash(userActive.login, 5000)
                activity?.recreate()
            }

            button_exit.setOnClickListener() {
                changeUser(null)
                val action = ProfileFragmentDirections.actionProfileFragmentToLoginFragment()
                findNavController().navigate(action)
            }
        }
    }
}