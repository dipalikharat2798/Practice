package com.androdevdk.mvvmretrofit.db

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.androdevdk.mvvmretrofit.api.QuoteService
import com.androdevdk.mvvmretrofit.api.RetrofitHelper
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException
import java.util.*

@RunWith(AndroidJUnit4::class)
class QuoteDatabaseTest {
    private lateinit var db: QuoteDatabase
    private lateinit var dao: QuoteDao
    private lateinit var quoteService: QuoteService

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, QuoteDatabase::class.java
        ).build()
        dao = db.quoteDao()
        quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    fun writeAndReadQuotes() = runBlocking {
        val result = quoteService.getQuotes(1)
        val bool1 = result?.body() != null
        if (result?.body() != null) {
            db.quoteDao().addQuotes(result.body()!!.results)
        }
        val quotes = db.quoteDao().getQuotes()
        val value = quotes.count() == 20
        Assert.assertTrue(value)
    }
}