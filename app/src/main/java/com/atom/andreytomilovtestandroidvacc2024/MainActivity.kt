package com.atom.andreytomilovtestandroidvacc2024

import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.atom.andreytomilovtestandroidvacc2024.databinding.ActivityMainBinding
import com.atom.andreytomilovtestandroidvacc2024.di.AppComponent

class MainActivity : AppCompatActivity() {

    private lateinit var appComponent: AppComponent
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        appComponent = (application as App).appComponent
        appComponent.inject(this)
        Log.d("AppComponent", "Injecting MainActivity")
        setupNavigation()
    }

    private fun setupNavigation() {

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
        val navController = navHostFragment.navController

    }
}