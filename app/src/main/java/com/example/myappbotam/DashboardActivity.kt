package com.example.myappbotam

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class DashboardActivity : AppCompatActivity() {
    lateinit var text: TextView
    lateinit var imagebtnone : ImageButton
    lateinit var imagebtntwo: ImageButton
    lateinit var imagebtnthree : ImageButton
    lateinit var imagebtnfour : ImageButton

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        text = findViewById(R.id.dash)
        imagebtnone = findViewById(R.id.viewcar)
        imagebtntwo = findViewById(R.id.book)
        imagebtnthree = findViewById(R.id.Contact_Us)
        imagebtnfour = findViewById(R.id.About_Us)
        // SetOnClick listeners
        imagebtnone.setOnClickListener {
            var gari = Intent(this,CarShow::class.java)
            startActivity(gari)
        }


        imagebtntwo.setOnClickListener {
            var nafasi = Intent(this,Booking::class.java)
            startActivity(nafasi)
        }
        imagebtnthree.setOnClickListener {
            var mawasiliano = Intent(this,Contact_Us::class.java)
            startActivity(mawasiliano)
        }
        imagebtnfour.setOnClickListener {
            var kuhusu = Intent(this,About_Us::class.java)
            startActivity(kuhusu)
        }
    }
}