package com.example.myappbotam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Splash_Screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        var splash = Thread{
            run {
                Thread.sleep(2000)
                startActivity(Intent(this,MainActivity::class.java))
            }
        }
        splash.start()
    }
}