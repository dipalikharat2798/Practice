package com.androdevdk.test1app

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    var preferred_language: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        preferred_language = findViewById(R.id.preferred_language);

    }

    fun onClick(view: View) {
        when (view.tag) {
            "english" ->// preferred_language!!.text = "English"
            {
//                intent = Intent(applicationContext, RecyclerviewActivity::class.java)
//                startActivity(intent)
            }
            "french" -> preferred_language!!.text = "French"
            "german" -> preferred_language!!.text = "German"
        }

        when(view.id){
            R.id.openBrowserButton -> {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("http://developer.android.com")
                startActivity(intent)
            }
        }
    }


}