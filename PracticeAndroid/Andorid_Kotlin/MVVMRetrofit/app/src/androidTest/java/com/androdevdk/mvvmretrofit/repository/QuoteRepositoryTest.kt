package com.androdevdk.mvvmretrofit.repository

import android.content.Context
import androidx.appcompat.widget.AppCompatDrawableManager.get
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.androdevdk.mvvmretrofit.api.QuoteService
import com.androdevdk.mvvmretrofit.api.RetrofitHelper
import com.androdevdk.mvvmretrofit.db.QuoteDao
import com.androdevdk.mvvmretrofit.db.QuoteDatabase
import com.androdevdk.mvvmretrofit.models.QuoteList
import com.androdevdk.mvvmretrofit.utils.NetworkUtils
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class QuoteRepositoryTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var quoteService: QuoteService
    private lateinit var quoteDatabase: QuoteDatabase
    private lateinit var applicationContext: Context
    private lateinit var dao: QuoteDao
    lateinit var quoteRepository: QuoteRepository

    @Before
    fun setUp() {
        quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
        applicationContext = ApplicationProvider.getApplicationContext<Context>()
        quoteDatabase = Room.inMemoryDatabaseBuilder(
            applicationContext, QuoteDatabase::class.java
        ).build()
        dao = quoteDatabase.quoteDao()
        quoteRepository = QuoteRepository(quoteService, quoteDatabase, applicationContext)
    }

    @After
    fun tearDown() {
        quoteDatabase.close()
    }

    @Test
    fun accessData() = runBlocking {
        if (NetworkUtils.isInternetAvailable(applicationContext)) {
            quoteRepository.getQuotes(1)
        }

        val result = quoteRepository.quotes
        assertTrue(result != null)
    }
}