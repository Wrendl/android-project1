package com.example.app1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.app1.main_list.EXTRA_MESSAGE1
import kotlinx.android.synthetic.main.activity_cart.*

class CartActivity : AppCompatActivity() {
    var balance = "10000"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        val sum = intent.getSerializableExtra(EXTRA_MESSAGE1) as? String
        sumToPay.text = sum

        availableBalance.text = balance

        confirmPayment.setOnClickListener() {
            if (sum != null) {
                val result = balance.toInt() - sum.toInt()

                if (result >= 0) {
                    balance = result.toString()
                    Toast.makeText(this, "Remaining balance is: $balance", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }else {
                    Toast.makeText(this, "Not enough balance", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}