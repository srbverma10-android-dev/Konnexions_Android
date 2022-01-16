package com.sourabhverma.recyclerviewandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView : RecyclerView

    private var adapter : Adapter = Adapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initialize
        recyclerView = findViewById(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(applicationContext)

        adapter.setArr(getDataFromApi())

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

    private fun getDataFromApi () : ArrayList<data>{
        val arr : ArrayList<data> = ArrayList()
        arr.add(data(1, "first element"))
        arr.add(data(1, "second element"))
        arr.add(data(0, "third element"))
        arr.add(data(0, "forth element"))
        return arr
    }

}