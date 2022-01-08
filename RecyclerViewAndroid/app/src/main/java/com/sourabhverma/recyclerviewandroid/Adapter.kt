package com.sourabhverma.recyclerviewandroid

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var arr : ArrayList<data> = ArrayList()

    fun setArr(arr : ArrayList<data>){
        this.arr = arr
    }

    class ViewHolder1(view: View) : RecyclerView.ViewHolder(view) {
        val textView1: TextView
        init {
            textView1 = view.findViewById(R.id.textView)
            textView1.setTextColor(Color.RED)
        }
    }
//    class ViewHolder2(view: View) : RecyclerView.ViewHolder(view) {
//        val textView2: TextView
//        init {
//            textView2 = view.findViewById(R.id.textView)
//            textView2.setTextColor(Color.GREEN)
//        }
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        return if (viewType == 0) {
//            val view = LayoutInflater.from(parent.context)
//                .inflate(R.layout.item, parent, false)
//            ViewHolder1(view)
//        }
//        else {
//            val view = LayoutInflater.from(parent.context)
//                .inflate(R.layout.item, parent, false)
//            ViewHolder2(view)
//        }
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item, parent, false)
        return ViewHolder1(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        if (getItemViewType(position) == 0){
//            holder as ViewHolder1
//            holder.textView1.text = arr[position].text
//        } else {
//            holder as ViewHolder2
//            holder.textView2.text = arr[position].text
//        }

        holder as ViewHolder1
        holder.textView1.text = arr[position].text

    }

//    override fun getItemViewType(position: Int): Int {
//        return arr[position].type
//    }

    override fun getItemCount(): Int {
        return arr.size
    }


}