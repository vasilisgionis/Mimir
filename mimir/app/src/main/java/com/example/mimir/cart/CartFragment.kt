package com.example.mimir.cart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mimir.Game
import com.example.mimir.R


class CartFragment : Fragment() {

    private lateinit var cartItem: MutableList<Game>
   // private lateinit var cartTextView: TextView
    private lateinit var cart: MutableList<CartItem>
    private lateinit var cartAdapter: CartAdapter
    private lateinit var viewModel: CartViewModel
    private lateinit var item_game_cart: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[CartViewModel::class.java]

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =inflater.inflate(R.layout.fragment_cart, container, false)
        cartItem = mutableListOf()
        cart = mutableListOf()
        cartAdapter = CartAdapter(viewModel, cartItem, ::onQuantityChanged)
        //cartTextView = view.findViewById(R.id.cartTextView)
       // updateCartTextViewVisibility()
        val cartRecyclerView = view.findViewById<RecyclerView>(R.id.cart_items)
        cartRecyclerView.adapter = cartAdapter
        cartRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        return view

    }
    private fun onQuantityChanged() {
        cartAdapter.notifyDataSetChanged()
        //updateCartTextViewVisibility()

    }
   /* private fun updateCartTextViewVisibility() {
        if (cart.isEmpty()) {
            //cartTextView.visibility = View.VISIBLE
            item_game_cart.visibility = View.GONE
        } else {
            //cartTextView.visibility = View.GONE
            item_game_cart.visibility = View.VISIBLE
        }
    }*/
}