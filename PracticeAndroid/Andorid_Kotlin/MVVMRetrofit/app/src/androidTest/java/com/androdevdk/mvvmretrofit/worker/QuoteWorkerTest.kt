package com.androdevdk.mvvmretrofit.worker

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.work.ListenableWorker
import androidx.work.testing.TestWorkerBuilder
import org.hamcrest.CoreMatchers.`is`
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.Result
import org.junit.runner.RunWith
import java.util.concurrent.Executor
import java.util.concurrent.Executors

@RunWith(AndroidJUnit4::class)
class QuoteWorkerTest {
    private lateinit var context: Context
    private lateinit var executor: Executor

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext()
        executor = Executors.newSingleThreadExecutor()
    }

    @Test
    fun testQuoteWorker() {
        val worker = TestWorkerBuilder<QuoteWorker>(
            context = context,
            executor = executor
        ).build()

        val result = worker.doWork()
        assertTrue(result == ListenableWorker.Result.success())
    }
}