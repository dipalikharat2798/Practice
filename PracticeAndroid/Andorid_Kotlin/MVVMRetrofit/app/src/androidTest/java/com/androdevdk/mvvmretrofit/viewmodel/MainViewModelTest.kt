package com.androdevdk.mvvmretrofit.viewmodel

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.androdevdk.mvvmretrofit.QuoteApplication
import com.androdevdk.mvvmretrofit.api.QuoteService
import com.androdevdk.mvvmretrofit.api.RetrofitHelper
import com.androdevdk.mvvmretrofit.db.QuoteDatabase
import com.androdevdk.mvvmretrofit.repository.QuoteRepository
import com.androdevdk.mvvmretrofit.repository.getOrAwaitValue
import kotlinx.coroutines.launch
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainViewModelTest {
    private lateinit var viewModel: MainViewModel

    @get:Rule
    val instantTaskException = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val db = Room.inMemoryDatabaseBuilder(context, QuoteDatabase::class.java)
            .allowMainThreadQueries().build()
        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
        val repo = QuoteRepository(quoteService, db, context)
        viewModel = MainViewModel(repo)
    }

    @Test
    fun testViewModel() {
        val result = viewModel.quotes.getOrAwaitValue().count
        assertTrue(result != null)
    }

    @After
    fun tearDown() {
    }
}