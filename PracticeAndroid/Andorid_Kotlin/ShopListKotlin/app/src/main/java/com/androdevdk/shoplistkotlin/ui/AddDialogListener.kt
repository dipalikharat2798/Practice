package com.androdevdk.shoplistkotlin.ui

import com.androdevdk.shoplistkotlin.data.db.entities.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item: ShoppingItem)
}