package com.androdevdk.test1app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recyclerview.*

class RecyclerviewActivity : AppCompatActivity() {
    private val itemsList = ArrayList<String>()
    private lateinit var customAdapter: CustomAdapter
    private val DATASET_COUNT = 50
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview)
        title = "RecyclerView - www.tutorialkart.com"

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        customAdapter = CustomAdapter(itemsList, this)
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = customAdapter
        prepareItems()
    }

    private fun prepareItems() {
        for (i in 0 until DATASET_COUNT) {
            itemsList.add("item_" + i)
        }

        customAdapter.notifyDataSetChanged()
    }
}