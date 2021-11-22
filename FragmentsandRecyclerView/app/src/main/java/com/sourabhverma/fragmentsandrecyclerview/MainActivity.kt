package com.sourabhverma.fragmentsandrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    private lateinit var frameLayout : FrameLayout
    private lateinit var fragmentOne: FragmentOne

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        frameLayout = findViewById(R.id.framelayout)
        fragmentOne = FragmentOne()

        val transaction : FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.framelayout,fragmentOne)
        transaction.addToBackStack(null)
        transaction.commit()

    }
}