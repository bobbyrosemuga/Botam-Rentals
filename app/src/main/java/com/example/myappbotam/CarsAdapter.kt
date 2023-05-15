package com.example.myappbotam

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class CarsAdapter(private val supplyList: ArrayList<ShowCars>)
    : RecyclerView.Adapter<CarsAdapter.FoodViewHolder>(){

    var onItemClick : ((ShowCars) -> Unit)? = null
    class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView : ImageView = itemView.findViewById(R.id.imageView)
        val textView1 : TextView = itemView.findViewById(R.id.textView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        return FoodViewHolder (LayoutInflater.from(parent.context).inflate(R.layout.activity_carshow, parent, false))

    }

    override fun getItemCount(): Int {
        return supplyList.size
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = supplyList[position]
        holder.imageView.setImageResource(food.image)
        holder.textView1.text = food.name

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(food)

        }

    }
}