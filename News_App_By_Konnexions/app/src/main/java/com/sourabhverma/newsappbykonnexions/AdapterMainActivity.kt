package com.sourabhverma.newsappbykonnexions

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import android.view.animation.Animation

import android.view.animation.ScaleAnimation
import kotlin.random.Random


open class AdapterMainActivity : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var arr : ArrayList<Article> = arrayListOf()
    private lateinit var context : Context

    fun appendArray(arr : Article, context: Context){
        this.arr.add(arr)
        this.context = context
    }

    class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView : ImageView = view.findViewById(R.id.imageView)
        val tittle : TextView = view.findViewById(R.id.tittle)
        val publishedAt : TextView = view.findViewById(R.id.publishedAt)
        val author : TextView = view.findViewById(R.id.author)
        val descrption : TextView = view.findViewById(R.id.description)
    }

    private var mLastPosition = -1

    private fun setAnimation(viewToAnimate: View, position: Int) {
        if (position > mLastPosition) {
            val anim = ScaleAnimation(
                0.0f,
                1.0f,
                1.0f,
                1.0f,
                Animation.RELATIVE_TO_SELF,
                0.5f,
                Animation.RELATIVE_TO_SELF,
                0.5f
            )
            anim.duration = 200 //to make duration random number between [0,501)
            viewToAnimate.startAnimation(anim)
            mLastPosition = position
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.news_list_xml, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as NewsViewHolder

        holder.tittle.text = arr[position].title
        holder.publishedAt.text = arr[position].publishedAt
        holder.descrption.text = arr[position].description
        holder.author.text = arr[position].author

        Glide.with(context).load(arr[position].urlToImage).into(holder.imageView)

//        setAnimation(holder.itemView, position);
    }

    override fun getItemCount(): Int {
        return arr.size
    }


}