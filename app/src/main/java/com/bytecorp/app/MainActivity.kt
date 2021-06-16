package com.bytecorp.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        val navController = navHostFragment.navController

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.signUpFragment -> {
                    window.statusBarColor = resources.getColor(R.color.white)
                    bottom.visibility = View.GONE
                }
                R.id.loginFragment -> {
                    window.statusBarColor = resources.getColor(R.color.white)
                    bottom.visibility = View.GONE
                }
                R.id.homeFragment -> {
                    window.statusBarColor = resources.getColor(R.color.white)
                    bottom.visibility = View.VISIBLE
                }
                R.id.profileFragment -> {
                    window.statusBarColor = resources.getColor(R.color.green)
                    bottom.visibility = View.VISIBLE
                }
                else -> {

                }
            }
        }
    }
}