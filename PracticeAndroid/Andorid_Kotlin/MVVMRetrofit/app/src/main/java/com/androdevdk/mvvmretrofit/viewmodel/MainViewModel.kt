package com.androdevdk.mvvmretrofit.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androdevdk.mvvmretrofit.models.QuoteList
import com.androdevdk.mvvmretrofit.repository.QuoteRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: QuoteRepository) : ViewModel() {
    init {
        viewModelScope.launch {
            repository.getQuotes(1)
        }
    }

    val quotes: LiveData<QuoteList>
        get() = repository.quotes
}