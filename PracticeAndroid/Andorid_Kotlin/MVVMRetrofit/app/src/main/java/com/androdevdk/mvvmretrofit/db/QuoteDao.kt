package com.androdevdk.mvvmretrofit.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.androdevdk.mvvmretrofit.models.Result
import kotlin.Result as Result1

@Dao
interface QuoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addQuotes(quotes:List<Result>)

    @Query("SELECT * FROM quote")
    suspend fun getQuotes():List<Result>

    @Query("SELECT * FROM quote ORDER BY quoteId DESC LIMIT 20")
    suspend fun getLast20Spends(): List<Result>
}