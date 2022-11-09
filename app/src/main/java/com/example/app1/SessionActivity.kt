package com.example.app1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.PopupMenu
import com.example.app1.data.session.Session
import com.example.app1.main_list.EXTRA_MESSAGE1
import kotlinx.android.synthetic.main.activity_session.*


class SessionActivity : AppCompatActivity() {
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
        }
        val popupMenu2 = PopupMenu(this, button)
        popupMenu2.inflate(R.menu.popup_menu)
        popupMenu2.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.adult -> {
                    tv.text = "Adult"
                }
                R.id.stud -> {
                    tv.text = "Stud"
                }
                R.id.child -> {
                    tv.text = "Child"
                }
                R.id.vip -> {
                    tv.text = "Vip"
                }
            }
            false
        }
        button.setOnClickListener {
            popupMenu2.show()
        }

    }
}