package com.androdevdk.shoplistkotlin.ui

import androidx.lifecycle.ViewModel
import com.androdevdk.shoplistkotlin.data.db.entities.ShoppingItem
import com.androdevdk.shoplistkotlin.data.repositories.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ShoppingViewModel(
    private val repository: ShoppingRepository
) : ViewModel() {
       fun upsert(item: ShoppingItem){
       GlobalScope.launch {
           repository.upsert(item)
       }
   }

    fun delete(item: ShoppingItem)=GlobalScope.launch {
        repository.delete(item)
    }
//    fun upsert(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
//        repository.upsert(item)
//    }
//    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
//        repository.delete(item)
//    }

    fun getAllShoppingItems() = repository.getAllShoppingItems()
}