package com.sourabhverma.newsappbykonnexions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView : RecyclerView

    private lateinit var viewModel : AndroidViewModel

    private var adapter : AdapterMainActivity = AdapterMainActivity()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initialize
        viewModel = ViewModelProvider(this@MainActivity).get(ViewModelMainActivity::class.java)

        recyclerView = findViewById(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(applicationContext)
        //------------------------------------------//

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter

        (viewModel as ViewModelMainActivity).getAllNews().observe(this, {
            if (it != null) {
                for(i in it.articles){
                    adapter.appendArray(i, this)
                    adapter.notifyItemInserted(adapter.itemCount-1)
                }
            }
        })
    }
}