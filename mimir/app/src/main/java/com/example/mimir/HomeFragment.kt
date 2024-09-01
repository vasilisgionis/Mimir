package com.example.mimir

import android.os.Bundle

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.lifecycle.ViewModelProvider
import com.example.mimir.cart.CartViewModel


class HomeFragment : Fragment() {
    lateinit var itemgame: RecyclerView
    private lateinit var viewModel: CartViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(requireActivity()).get(CartViewModel::class.java)

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemgame=view.findViewById(R.id.item_game)
        var gameCatalogue=mutableListOf(
            Game(id=1,title="GTAV online",description="...", category = "Action", date=2017,price=39.99,rating=4, review =mutableListOf(Review(review = "Amazing game",rating=4)),players="Multiplayer",discount=0.0),
            Game(id=2,title="Stardew Valley",description="...", category = "Action", date=2017,price=15.99,rating=4, review =mutableListOf(Review(review = "Amazing game",rating=4)),players="Single",discount=0.0),
            Game(id=3,title="Witcher 3",description="...", category = "Action", date=2017,price=59.99,rating=4, review =mutableListOf(Review(review = "Amazing game",rating=4)),players="Single",discount=9.0),
            Game(id=4,title="Minecraft",description="...", category = "Action", date=2017,price=24.99,rating=4, review =mutableListOf(Review(review = "Amazing game",rating=4)),players="Single",discount=10.0),
            Game(id=5,title="Age of Empires II",description="...", category = "Action", date=2017,price=4.99,rating=4, review =mutableListOf(Review(review = "Amazing game",rating=4)),players="Multiplayer",discount=0.0)
        )
        val adapter=GameAdapter(gameCatalogue, ::onAddToCartClicked)
        itemgame.adapter=adapter
        itemgame.layoutManager=LinearLayoutManager(context)


    }
    private fun onAddToCartClicked(game: Game) {
        viewModel.addToCart(game)
        Toast.makeText(context, "${game.title} added to cart", Toast.LENGTH_SHORT).show()
    }
}