package com.geico.adexpress.adexpress.ui.spendTracker

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.geico.adexpress.adexpress.data.SpendDatabase
import com.geico.adexpress.adexpress.data.SpendsTrackerDataSource
import org.junit.*

import org.junit.Assert.*
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SpendViewModelTest {

    private lateinit var viewModel: SpendViewModel

    @get:Rule
    val instantTaskException = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val db = Room.inMemoryDatabaseBuilder(context, SpendDatabase::class.java)
            .allowMainThreadQueries().build()
        val dataSource = SpendsTrackerDataSource(db.getSpendDao())
        viewModel = SpendViewModel(dataSource)
    }

    @Test
    fun testSpendViewModel() {
        viewModel.addSpend(100, "viewmodel")
        viewModel.getLast20Spends()
        val result = viewModel.last20SpendsLiveData.getOrAwaitValue().find {
            it.amount == 100 && it.description == "viewmodel"
        }
        assertTrue(result != null)
    }

    @After
    fun tearDown() {
    }

}