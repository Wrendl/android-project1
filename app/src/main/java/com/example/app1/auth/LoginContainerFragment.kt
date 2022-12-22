package com.example.app1.auth

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.app1.R
import kotlinx.android.synthetic.main.login_container.*
import androidx.recyclerview.widget.LinearLayoutManager

class LoginContainerFragment: Fragment(R.layout.login_container) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragment = LoginFragment()
        (activity as AppCompatActivity).supportFragmentManager.commit {
            replace(R.id.containerView, fragment)
        }
    }
}