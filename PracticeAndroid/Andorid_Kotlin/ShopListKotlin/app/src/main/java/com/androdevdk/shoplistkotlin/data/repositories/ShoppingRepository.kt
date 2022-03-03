package com.androdevdk.shoplistkotlin.data.repositories

import com.androdevdk.shoplistkotlin.data.db.ShoppingDatabase
import com.androdevdk.shoplistkotlin.data.db.entities.ShoppingItem

class ShoppingRepository(
    private val db: ShoppingDatabase
) {
    suspend fun upsert(item: ShoppingItem) = db.getShoppingDao().upsert(item)

    suspend fun delete(item: ShoppingItem) = db.getShoppingDao().delete(item)

    fun getAllShoppingItems() = db.getShoppingDao().getAllShoppingItem()
}