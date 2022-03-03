package com.androdevdk.mvvmretrofit.utils

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(AndroidJUnit4::class)
class NetworkUtilsTest {
    lateinit var context: Context

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext<Context>()
    }

    @Test
    fun checkAvailabilityofInternet() {
        val result = NetworkUtils.isInternetAvailable(context)
        assertTrue(result)
    }
    @Test
    fun checkUnavailabilityofInternet() {
        val result = NetworkUtils.isInternetAvailable(context)
        assertFalse(result)
    }

    @After
    fun tearDown() {
    }
}