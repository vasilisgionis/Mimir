package com.example.mimir.cart

import com.example.mimir.Game

class Cart {
    private val items = mutableListOf<Game>()

    fun getItems(): List<Game> {
        return items.toList()
    }

    fun addGame(game: Game) {
        items.add(game);
    }

    fun removeGame(game: Game) {
        items.remove(game);
    }

    fun getTotalPrice(): Double {
        return items.sumOf { it.price }
    }
}