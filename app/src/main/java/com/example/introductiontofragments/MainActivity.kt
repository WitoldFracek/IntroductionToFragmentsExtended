package com.example.introductiontofragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = findNavController(R.id.nav_host_fragment_container)

        val btmNavMenu: BottomNavigationView = findViewById(R.id.bottom_nav)
//        btmNavMenu.setOnItemSelectedListener { item ->
//            when(item.itemId) {
//                R.id.left_nav -> navController.navigate(R.id.action_global_tabsFragment)
//                R.id.centre_nav -> navController.navigate(R.id.action_global_fragment1)
//                R.id.right_nav -> navController.navigate(R.id.action_global_swipeFragment2)
//            }
//            true
//        }
    }
}