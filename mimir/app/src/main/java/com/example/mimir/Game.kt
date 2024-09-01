package com.example.mimir

data class Game(
    val id: Int,
    val title: String,
    val description: String,
    val category: String,
    val date: Int,
    val price: Double,
    val rating: Int,
    val review: List<Review>,
    val players: String,val discount: Double)

