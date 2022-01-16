package com.sourabhverma.recyclerview

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>()  {
    private var arr : ArrayList<data> = ArrayList()

    //Setter
    fun setArr(arr : ArrayList<data>){
        this.arr = arr
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)
        return ViewHolder1(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as ViewHolder1
        holder.textView1.text = arr[position].text2
        Log.d("TAG", "onBindViewHolder: $position and text = ${arr[position].text2}")
    }

    override fun getItemCount(): Int {
        return arr.size
    }

    class ViewHolder1(view: View) : RecyclerView.ViewHolder(view) {
        val textView1: TextView
        init {
            textView1 = view.findViewById(R.id.textView)
            textView1.setTextColor(Color.RED)
        }
    }
}
