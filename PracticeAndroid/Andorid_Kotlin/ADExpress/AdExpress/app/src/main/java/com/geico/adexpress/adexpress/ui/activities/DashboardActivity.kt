package com.geico.adexpress.adexpress.ui.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.geico.adexpress.adexpress.R
import com.geico.adexpress.adexpress.util.CustomAdapter


class DashboardActivity : AppCompatActivity() {
    private val DATASET_COUNT = 50
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        val recyclerView = findViewById<View>(R.id.recyclerView) as RecyclerView

        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager

        val dataSet: MutableList<String> = ArrayList(DATASET_COUNT)
        for (i in 0 until DATASET_COUNT) {
            dataSet.add(getString(R.string.item_element_text) +"_"+i)
        }
        val adapter = CustomAdapter(dataSet, applicationContext)
        recyclerView.adapter = adapter
    }
}