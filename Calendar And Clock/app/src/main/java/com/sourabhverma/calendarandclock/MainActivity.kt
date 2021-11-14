package com.sourabhverma.calendarandclock

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var button1 : Button
    private lateinit var button2 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Init
        button1 = findViewById(R.id.openCalendar)
        button2 = findViewById(R.id.openClock)

        button1.setOnClickListener {
            Toast.makeText(this@MainActivity, "Opening Calendar", Toast.LENGTH_SHORT).show()
            val openCalendar : Intent  = Intent(this, CalendarActivity::class.java)
            openCalendar.putExtra("FromMainActivity", "Konnexions")
            startActivity(openCalendar)
        }

        button2.setOnClickListener {
            Toast.makeText(this@MainActivity, "Opening Clock", Toast.LENGTH_SHORT).show()
            val openClock : Intent  = Intent(this, ClockActivity::class.java)
            startActivity(openClock)
        }

    }
}
