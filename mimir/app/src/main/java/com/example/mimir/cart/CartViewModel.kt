package com.example.mimir.cart

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mimir.Game

class CartViewModel: ViewModel() {
    private val _cartItems= MutableLiveData<MutableList<CartItem>>(mutableListOf())
    val cartItems: MutableLiveData<MutableList<CartItem>> = _cartItems

    fun addToCart(game: Game) {
        val currentItem = _cartItems.value ?: mutableListOf()
        val existingItem = currentItem.find { it.game == game }
        if (existingItem != null) {
            existingItem.quantity++
        } else {
            currentItem.add(CartItem(game, 1))
        }
        _cartItems.value = currentItem
    }


}