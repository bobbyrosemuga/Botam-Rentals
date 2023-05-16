package com.example.myappbotam

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CarviewsActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var supplyAdapter: CarsAdapter
    lateinit var supplyList: ArrayList<ShowCars>
            ;

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carviews)
        recyclerView = findViewById(R.id.rcycleSupplies)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        supplyList = ArrayList()


        supplyList.add(ShowCars(R.drawable.merc,"Mercedes G 350D"," Excellent handling ⋅ Agile and effortless when driving off-road ⋅ Better steering feel ⋅ "))
        supplyList.add(ShowCars(R.drawable.audir8,"Audi R8","This motorsport-inspired technology combined with rear-wheel drive allows for 7 levels of traction adjustability."))
        supplyList.add(ShowCars(R.drawable.porshe,"Porsche Cayenne","3 Petrol Engine on offer. The Petrol engine is 2995 cc and 3998 cc and 3996 cc . It is available with Automatic transmission. Depending upon the variant and fuel type the Cayenne has a mileage of 12.5 kmpl & Ground clearance of Cayenne is 190mm."))
        supplyList.add(ShowCars(R.drawable.redaudi,"Audi A4"," is a line of luxury compact executive cars produced since 1994 by the German car manufacturer Audi"))
        supplyList.add(ShowCars(R.drawable.audikid,"Toyota Vitz","he Toyota Vitz fuel consumption for a 1300 cc engine is on average 18 km/L. ... Toyota Vitz 1000cc Fuel Consumption/Vitz 1000cc Fuel Average."))
        supplyList.add(ShowCars(R.drawable.audir8,"Subaru Legacy"," a mid-size car built by Japanese automobile manufacturer Subaru since 1989. The maker's flagship car, it is unique in its class for ..."))
        supplyList.add(ShowCars(R.drawable.mazdacx,"Mazda CX"," On a road trip no matter how far or how close it is to home, you will want to be as safe as possible. Mazda excels in this category especially with the CX-5 as it gets more standard kits across the board."))
        supplyList.add(ShowCars(R.drawable.mazdasedan,"Mazda Sedan","The ability to accommodate four or five passengers makes it a roomy, comfortable car for most drivers."))

        supplyAdapter = CarsAdapter(supplyList)
        recyclerView.adapter = supplyAdapter





    }
}