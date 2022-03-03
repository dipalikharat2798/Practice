package com.androdevdk.designpattern

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var database: ContactDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        database = ContactDatabase.getDatabase(this)
        // val database1 = ContactDatabase.getDatabase(this)
//        database=Room.databaseBuilder(applicationContext,
//        ContactDatabase::class.java,
//        "contactDB").build()
        GlobalScope.launch {
            database.contactDao().insertContact(Contact(0, "dk", "1234567890", Date(),1))
        }

    }

    fun getData(view: View) {
        database.contactDao().getListOfContact().observe(this, Observer {
            Log.d("TAG", "getData: " + it.toString())
        })
    }

    fun addMultiple(view: View) {

    }
}