package com.sourabhverma.calendarandclock

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CalendarView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class CalendarActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var calendarView: CalendarView
    private lateinit var parentVeiw : RelativeLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        //Init
        textView = findViewById(R.id.textView)
        calendarView = findViewById(R.id.calendar)
        parentVeiw = findViewById(R.id.parentView)

        val data = intent.getStringExtra("FromMainActivity")
        textView.text = data

        calendarView.setOnDateChangeListener { calendarView, year, month, day ->
            Snackbar.make(parentVeiw, "$day / ${month+1} / $year", Snackbar.LENGTH_SHORT).show()
        }

    }
}