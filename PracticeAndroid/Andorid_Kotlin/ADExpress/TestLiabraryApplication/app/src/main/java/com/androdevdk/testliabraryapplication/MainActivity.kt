package com.androdevdk.testliabraryapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.androdevdk.mydatelibrary.DateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calendar: Calendar = Calendar.getInstance()
        val dateTime = DateFormat.changeFormat(calendar.time)
        Log.d("TAG", "onCreate: " + calendar.time + "\n" + dateTime)
        Toast.makeText(this, "" + dateTime, Toast.LENGTH_SHORT).show()
    }
}