package com.example.app1.auth

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.app1.R
import com.example.app1.data.user.UserDao
import com.example.app1.data.user.UserDatabase
import com.example.app1.data.user.UserViewModel
import kotlinx.android.synthetic.main.profile_fragment.*
import java.lang.Exception
import kotlin.math.log

class ProfileFragment: Fragment(R.layout.profile_fragment) {

    private lateinit var mUserViewModel: UserViewModel
    private val args: ProfileFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        username_text.text = mUserViewModel.getUserByLogin(args.login).login
    }
}