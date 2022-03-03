package com.example.jetpackapp.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ContactDAO {
    @Insert
    suspend fun insertContact(contact: Contact)

    @Update
    suspend fun updateContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

    @Query("SELECT * FROM contact")
    fun getData(): LiveData<List<Contact>>

    //coroutine execute on bgthread
}