package com.example.app1.data.tickets

import androidx.room.PrimaryKey
import com.example.app1.data.session.Session
import java.io.Serializable
import java.sql.RowId
import java.sql.Types

class Tickets(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val rowId: Int,
    val columnId: Int,
    val typeOfTicket: String,
    val session: Session,
    val filmImageId: Int
): Serializable {
}
