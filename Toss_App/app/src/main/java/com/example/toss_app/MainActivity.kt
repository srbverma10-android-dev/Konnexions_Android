package com.example.toss_app

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var image:ImageView
    lateinit var toss_text:TextView
    lateinit var toss_button:Button
    lateinit var count:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        image=findViewById(R.id.choice)
        toss_text=findViewById(R.id.toss_text)
        toss_button=findViewById(R.id.toss_button)
        count=findViewById(R.id.count_view)

        val imageList= mutableListOf(R.drawable.heads,R.drawable.tails)
        var textSen= mutableListOf("Heads it is . . .","Tails it is . . . ")
        var hc=0
        var tc=0
        var frontAnimation=
            AnimatorInflater.loadAnimator(applicationContext,R.animator.toss_anim) as AnimatorSet
        toss_button.setOnClickListener {
            var rand=Random.nextInt(2)
            image.setImageResource(imageList[rand])
            toss_text.text=textSen[rand]
            frontAnimation.setTarget(image)
            frontAnimation.start()
            if(rand==0)
                hc+=1
            else
                tc+=1

            count.text="Heads="+hc+"   Tails="+tc
        }
    }
}