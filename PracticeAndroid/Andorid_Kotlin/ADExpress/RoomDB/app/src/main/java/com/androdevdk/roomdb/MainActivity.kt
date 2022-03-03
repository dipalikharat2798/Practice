package com.androdevdk.roomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.androdevdk.roomdb.database.ContactDatabase
import com.androdevdk.roomdb.entity.Contact
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
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
            // database.contactDao().insertContact(Contact(0, "dk", "1234567890"))

            var contactData: MutableList<Contact> = mutableListOf<Contact>()
            contactData.add(Contact(0, "dk1", "1234567890"))
            contactData.add(Contact(0, "dk2", "1234567890"))
            contactData.add(Contact(0, "dk4", "1234567890"))
            database.contactDao().insertMultipleContacts(contactData)
            Log.d(TAG, "onCreate: " + "Data inserted successfully...")
        }
    }

    fun getData(view: View) {
        database.contactDao().getListOfContact().observe(this, androidx.lifecycle.Observer {
            Log.d("TAG", "getData: " + it.toString())
        })
    }
}