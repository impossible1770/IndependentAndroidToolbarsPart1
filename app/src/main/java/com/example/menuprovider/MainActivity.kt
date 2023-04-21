package com.example.menuprovider

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.menuprovider.frament.HomeFragment
import com.example.menuprovider.frament.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var bottomNav: BottomNavigationView
    private val fragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNav = findViewById(R.id.bottom_nav)
        bottomNav.setOnItemSelectedListener { item ->
            val fragment: Fragment = when (item.itemId) {
                R.id.nav_home -> HomeFragment()
                R.id.nav_profile -> ProfileFragment()
                else -> return@setOnItemSelectedListener false
            }
            fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit()
            true
        }

        // Load the first fragment into the container
        val fragment = HomeFragment()
        fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.btnSecond -> {
                Toast.makeText(this, "Common listener from MainActivity", Toast.LENGTH_SHORT).show()
                true
            }

            else -> false
        }
    }
}