package com.example.mimir.cart

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.mimir.Game
import com.example.mimir.R
import com.google.android.material.button.MaterialButton


class CartAdapter(private var viewModel: CartViewModel, var cartItems: List<Game>, onQuantityChanged: () -> Unit) : RecyclerView.Adapter<CartAdapter.CartViewHolder>(){

    private lateinit var cartAdapter: CartAdapter
    inner class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val cartgameTitle: TextView = itemView.findViewById(R.id.cart_game_title)
        val cartgameDescription: TextView = itemView.findViewById(R.id.cart_game_description)
        val cartadd_to_cart_button: MaterialButton = itemView.findViewById(R.id.duplicate_cart_button)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_game_cart,parent,false)
        return CartViewHolder(view)
    }
    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val game = cartItems[position]
        holder.cartgameTitle.text = game.title
        holder.cartgameDescription.text = game.description
        holder.cartadd_to_cart_button.setOnClickListener {
            viewModel.addToCart(game)
            notifyDataSetChanged()
            onQuantityChanged()
        }
    }

    override fun getItemCount(): Int {
        return cartItems.size
    }
    @SuppressLint("NotifyDataSetChanged")
    private fun onQuantityChanged() {
        cartAdapter.notifyDataSetChanged()
    }
}