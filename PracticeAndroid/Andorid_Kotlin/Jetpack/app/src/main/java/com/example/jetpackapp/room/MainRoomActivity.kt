package com.example.jetpackapp.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.room.Room
import com.example.jetpackapp.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class MainRoomActivity : AppCompatActivity() {
    private  val TAG = "MainRoomActivity"
    lateinit var database: ContactDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_room)
        database= ContactDatabase.getDatabase(this)
        GlobalScope.launch {
            database.contactDao().insertContact(Contact(0,"John","999999999",Date(),1))
        }
    }

    fun getData(view: View) {
        database.contactDao().getData().observe(this, Observer {
            Log.d(TAG, "getData: "+it.toString())
        })
    }
}