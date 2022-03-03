package com.geico.adexpress.adexpress.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface SpendDao {
    @Insert
    suspend fun addSpend(spend: Spend)

    @Delete
    suspend fun deleteSpend(spend: Spend)

    @Query("SELECT * FROM spend ORDER BY date DESC LIMIT 20")
    suspend fun getLast20Spends(): List<Spend>

}