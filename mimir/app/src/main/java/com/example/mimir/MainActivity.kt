package com.example.mimir

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.example.mimir.cart.Cart
import com.example.mimir.cart.CartFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity :AppCompatActivity() {
    private val cart = Cart()
    private val wishlist = Wishlist()
    lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigationView=findViewById(R.id.bottomNavigationView)
        val homeFragment=HomeFragment()
        val cartFragment= CartFragment()
        val wishlistFragment=WishlistFragment()
        setCurrentFragment(homeFragment)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        navController.navigate(R.id.HomeFragment)
        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.miHome->setCurrentFragment(homeFragment)
                R.id.miCart->setCurrentFragment(cartFragment)
                R.id.miWishlist->setCurrentFragment(wishlistFragment)
            }
            true
        }

    }
    fun setCurrentFragment(fragment: Fragment) {
    supportFragmentManager.beginTransaction().apply {
        replace(R.id.flFragment, fragment)
        addToBackStack(null)
        commit()
        }
    }
}