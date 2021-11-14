package com.sourabhverma.calendarandclock

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AnalogClock

class ClockActivity : AppCompatActivity() {

    private lateinit var clock : AnalogClock

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clock)
    }
}