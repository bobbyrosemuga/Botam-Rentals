package com.example.myappbotam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CarshowActivity : AppCompatActivity() {


    private var layoutManager : RecyclerView.LayoutManager? = null
    private var adapter : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_show)

        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager as LinearLayoutManager

        adapter = RecyclerViewAdapter ()
        recyclerView.adapter = adapter as RecyclerViewAdapter

    }
}