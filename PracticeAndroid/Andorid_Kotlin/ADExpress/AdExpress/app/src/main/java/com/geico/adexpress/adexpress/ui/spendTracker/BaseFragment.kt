package com.geico.adexpress.adexpress.ui.spendTracker

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.geico.adexpress.adexpress.data.SpendDatabase
import com.geico.adexpress.adexpress.data.SpendsTrackerDataSource

abstract class BaseFragment(@LayoutRes layout: Int) : Fragment(layout) {

    protected lateinit var viewModel: SpendViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = SpendDatabase(requireContext())
        val dataSource = SpendsTrackerDataSource(db.getSpendDao())
        val factory = ViewModelFactory(dataSource)
        viewModel = ViewModelProvider(this, factory).get(SpendViewModel::class.java)
    }
}