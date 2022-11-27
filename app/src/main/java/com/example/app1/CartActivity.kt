package com.example.app1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.app1.data.tickets.Tickets
import com.example.app1.data.user.UserViewModel
import kotlinx.android.synthetic.main.activity_cart.*

class CartActivity : AppCompatActivity() {

    private lateinit var mUserViewModel: UserViewModel
    var balance = getActiveUser()?.money.toString()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        val sum = intent.getSerializableExtra("sumResult") as? String
        sumToPay.text = sum

        val listOfTickets = intent.getSerializableExtra("listOfTickets") as? ArrayList<*>

        availableBalance.text = balance

        confirmPayment.setOnClickListener() {
            if (sum != null) {
                val result = balance.toInt() - sum.toInt()

                if (result >= 0) {
                    balance = result.toString()

                    addTicketsToCart(listOfTickets)

                    mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
                    getActiveUser()?.let { it1 -> mUserViewModel.deleteCash(it1.login, sum.toInt()) }

                    Toast.makeText(this, "Remaining balance is: $balance", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }else {
                    Toast.makeText(this, "Not enough balance", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun addTicketsToCart(listOfTickets: ArrayList<*>?) {
        if (listOfTickets != null) {
            for (i in 0 until listOfTickets.size) {
                addToMyTickets(listOfTickets[i] as Tickets?)
            }
        }
    }
}