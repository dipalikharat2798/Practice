package com.androdevdk.roomdb.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.androdevdk.roomdb.entity.Contact

@Dao
interface ContactDao {
    @Insert
    suspend fun insertContact(contact: Contact)

    @Update
    suspend fun updateContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

    @Query("SELECT * from contact")
    fun getListOfContact(): LiveData<List<Contact>>

    @Insert
    suspend fun insertMultipleContacts(contact: List<Contact>)
}