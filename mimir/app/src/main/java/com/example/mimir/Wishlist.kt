package com.example.mimir

class Wishlist {

    private val items = mutableListOf<Game>()
    fun getItems(): List<Game> {
        return items.toList()
    }
    fun addItem(game: Game) {
        items.add(game)
    }
    fun removeItem(game: Game) {
        items.remove(game)
    }
}