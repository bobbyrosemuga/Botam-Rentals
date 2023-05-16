package com.example.myappbotam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class BookingActivity : AppCompatActivity() {
    lateinit var textBook : TextView
    lateinit var bookTxt : TextView
    lateinit var bookFill : EditText
    lateinit var dayText: EditText
    lateinit var dayFill : EditText
    lateinit var btn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking)
        textBook = findViewById(R.id.bookText)
        bookTxt =  findViewById(R.id.txtName)
        bookFill =  findViewById(R.id.editName)
        dayText =  findViewById(R.id.dayTxt)
        dayFill =  findViewById(R.id.fill_days)
        btn = findViewById(R.id.pay_btn)

    }
}