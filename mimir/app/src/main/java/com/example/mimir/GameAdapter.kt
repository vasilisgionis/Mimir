package com.example.mimir

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton

class GameAdapter(var gamecatalogue: List<Game>,private val onAddToCartClicked: (Game) -> Unit): RecyclerView.Adapter<GameAdapter.GameViewHolder>() {
    inner class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val gameTitle: TextView = itemView.findViewById(R.id.game_title)
        val gameDescription: TextView = itemView.findViewById(R.id.game_description)
        val add_to_cart_button: MaterialButton = itemView.findViewById(R.id.add_to_cart_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_game, parent, false)
        return GameViewHolder(view)
    }

    override fun getItemCount(): Int {
        return gamecatalogue.size
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val game = gamecatalogue[position]
        holder.gameTitle.text = game.title
        holder.gameDescription.text = game.description
        holder.add_to_cart_button.setOnClickListener {
            onAddToCartClicked(game)
        }
    }
}