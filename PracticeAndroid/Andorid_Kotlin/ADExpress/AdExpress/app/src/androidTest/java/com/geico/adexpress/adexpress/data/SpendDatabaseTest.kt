package com.geico.adexpress.adexpress.data

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException
import java.util.*

@RunWith(AndroidJUnit4::class)
class SpendDatabaseTest {
    private lateinit var db: SpendDatabase
    private lateinit var dao: SpendDao

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, SpendDatabase::class.java
        ).build()
        dao = db.getSpendDao()

    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }


    @Test
    fun writeAndReadSpend() = runBlocking {
        val date = Date()
        val spend = Spend(date, 100, "description")
        dao.addSpend(spend)
        val spends = dao.getLast20Spends()
        val result = spends.contains(spend)
      Assert.assertTrue(result)
       // assertThat(result).isTrue()
    }

}