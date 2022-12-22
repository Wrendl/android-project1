package com.example.app1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.PopupMenu
import com.example.app1.data.session.Session
import com.example.app1.data.tickets.Tickets
import com.example.app1.main_list.EXTRA_MESSAGE
import com.example.app1.main_list.EXTRA_MESSAGE1
import kotlinx.android.synthetic.main.activity_session.*


class SessionActivity : AppCompatActivity() {
    var selectedButton = "-"
    var totalTickets = mapOf(
        "Взрослый" to 0,
        "Студ." to 0,
        "Детский" to 0,
        "VIP" to 0
        )
    var listOfTickets = ArrayList<Tickets>()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_session)

        val session = intent.getSerializableExtra(EXTRA_MESSAGE1) as? Session

        if (session != null) {
            tvTime.text = session.time
            tvSessionFilmTitle.text = session.filmTitle
            tvSessionCinemaTitle.text = session.cinemaTitle
            tvSessionLanguage.text = session.language
            tvSessionPriceAdult.text = session.priceAdult
            tvSessionPriceStud.text = session.priceStud
            tvSessionPriceChild.text = session.priceChild
            tvSessionPriceVip.text = session.priceVip


            val popupMenu2 = PopupMenu(this, buttonMain)
            popupMenu2.inflate(R.menu.popup_menu)
            popupMenu2.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.adult -> {
                        printTickets("Взрослый")
                        addToArrTickets("Взрослый", session)
                    }
                    R.id.stud -> {
                        printTickets("Студ.")
                        addToArrTickets("Студ.", session)
                    }
                    R.id.child -> {
                        printTickets("Детский")
                        addToArrTickets("Детский", session)
                    }
                }
                false
            }

            val popupMenuVip = PopupMenu(this, buttonMain)
            popupMenuVip.inflate(R.menu.popup_menu_vip)
            popupMenuVip.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.vip -> {
                        printTickets("VIP")
                        addToArrTickets("VIP", session)
                    }
                }
                false
            }

            val buttons = getButtons()
            for (i in 0 until buttons.size - 8) {
                buttons[i].setOnClickListener{
                    popupMenu2.show()
                    selectedButton = buttons[i].text.toString()
                }
            }

            for (i in buttons.size - 8 until buttons.size) {
                buttons[i].setOnClickListener{
                    popupMenuVip.show()
                    selectedButton = buttons[i].text.toString()
                }
            }
        }

        buttonNext.setOnClickListener() {
            var sum = 0
            if (session != null) {
                sum += totalTickets["Взрослый"]!! * session.priceAdult.toInt()
                sum += totalTickets["Студ."]!! * session.priceStud.toInt()
                sum += totalTickets["Детский"]!! * session.priceChild.toInt()
                sum += totalTickets["VIP"]!! * session.priceVip.toInt()
            }

            var sumResult = sum.toString()
            val intent = Intent(this, CartActivity::class.java).apply{
                putExtra("sumResult", sumResult)
                putExtra("listOfTickets", listOfTickets)
            }
            startActivity(intent)
        }
    }

    private fun addToArrTickets(ticketType: String, session: Session) {
        val rowId = selectedButton[0].toInt() - 48
        val columnId = selectedButton[1].toInt() - 48
        val imageId = getImageFromFilm(session.filmId)

        val ticket = Tickets(0,rowId, columnId, ticketType, session, imageId)
        listOfTickets.add(ticket)
    }

    private fun printTickets(type: String) {
        var answer = ""
        var intAdd = totalTickets[type]
        if (intAdd != null) {
            totalTickets = totalTickets + mapOf(type to (intAdd + 1))
        }

        if ( totalTickets["Взрослый"] != 0 ){
            answer = answer + "Взрослый: " + totalTickets["Взрослый"].toString() + "\n"
        }
        if ( totalTickets["Студ."] != 0 ){
            answer = answer + "Студ.: " + totalTickets["Студ."].toString() + "\n"
        }
        if ( totalTickets["Детский"] != 0 ){
            answer = answer + "Детский: " + totalTickets["Детский"].toString() + "\n"
        }
        if ( totalTickets["VIP"] != 0 ){
            answer = answer + "VIP: " + totalTickets["VIP"].toString() + "\n"
        }
        tv.text = answer
    }

    private fun getButtons(): ArrayList<Button> {
        val buttons = ArrayList<Button>()
        buttons.add(button11)
        buttons.add(button12)
        buttons.add(button13)
        buttons.add(button14)
        buttons.add(button15)
        buttons.add(button16)
        buttons.add(button17)
        buttons.add(button18)


        buttons.add(button21)
        buttons.add(button22)
        buttons.add(button23)
        buttons.add(button24)
        buttons.add(button25)
        buttons.add(button26)
        buttons.add(button27)
        buttons.add(button28)


        buttons.add(button31)
        buttons.add(button32)
        buttons.add(button33)
        buttons.add(button34)
        buttons.add(button35)
        buttons.add(button36)
        buttons.add(button37)
        buttons.add(button38)


        buttons.add(button41)
        buttons.add(button42)
        buttons.add(button43)
        buttons.add(button44)
        buttons.add(button45)
        buttons.add(button46)
        buttons.add(button47)
        buttons.add(button48)


        buttons.add(button51)
        buttons.add(button52)
        buttons.add(button53)
        buttons.add(button54)
        buttons.add(button55)
        buttons.add(button56)
        buttons.add(button57)
        buttons.add(button58)


        buttons.add(button61)
        buttons.add(button62)
        buttons.add(button63)
        buttons.add(button64)
        buttons.add(button65)
        buttons.add(button66)
        buttons.add(button67)
        buttons.add(button68)
        return buttons
    }
}