package com.example.myappbotam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class CarshowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carviews)
        val supplies = intent.getParcelableExtra<ShowCars>("Supplies")
        if (supplies !=null){
            val textView1 : TextView = findViewById(R.id.textView)
            val textView2 : TextView = findViewById(R.id.description)
            val imageView : ImageView = findViewById(R.id.imageView)

            textView1.text = supplies.name
            imageView.setImageResource(supplies.image)
            textView2.text = supplies.description
        }
    }
}