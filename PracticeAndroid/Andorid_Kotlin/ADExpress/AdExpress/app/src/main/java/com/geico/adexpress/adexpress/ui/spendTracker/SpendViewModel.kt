package com.geico.adexpress.adexpress.ui.spendTracker

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.geico.adexpress.adexpress.data.Spend
import com.geico.adexpress.adexpress.data.SpendsTrackerDataSource
import kotlinx.coroutines.launch
import java.util.*

class SpendViewModel(
    private val dataSource: SpendsTrackerDataSource
) : ViewModel() {

    private val _last20SpendsLiveData = MutableLiveData<List<Spend>>()
    val last20SpendsLiveData: LiveData<List<Spend>>
        get() = _last20SpendsLiveData

     fun addSpend(amount: Int, description: String) = viewModelScope.launch {
        dataSource.addSpend(Spend(Date(), amount, description))
    }

    fun getLast20Spends() = viewModelScope.launch {
        _last20SpendsLiveData.value = dataSource.getLast20Spends()
    }
}