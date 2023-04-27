package com.example.myappbotam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class UserActivity : AppCompatActivity() {
    lateinit var myimage: ImageView
    lateinit var mText: TextView
    lateinit var btnChoose: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_activity)
        myimage = findViewById(R.id.imageView)
        mText = findViewById(R.id.ViewT)
        btnChoose = findViewById(R.id.bTn)
        btnChoose.setOnClickListener {
            var gari = Intent(this,CarShow::class.java)
            startActivity(gari)
        }

    }
}