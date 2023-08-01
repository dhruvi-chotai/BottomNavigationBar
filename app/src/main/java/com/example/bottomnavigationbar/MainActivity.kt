package com.example.bottomnavigationbar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnItemSelectedListener { item ->
            val fragment: Fragment = when (item.itemId) {
                R.id.nav_notification -> NotificationFragment()
                R.id.nav_home -> HomeFragment()
                R.id.nav_dashboard -> DashboardFragment()

                    else -> HomeFragment()
            }

            supportFragmentManager.beginTransaction()
                .replace(R.id.frame_container, fragment)
                .commit()

            true
        }

        // Set the HomeFragment as the default fragment
        val defaultFragment = HomeFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_container, defaultFragment)
            .commit()
    }
}