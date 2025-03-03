package com.example.gitrequester.presentetion.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.gitrequester.R
import com.example.gitrequester.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolBar: Toolbar = binding.toolbar
        setSupportActionBar(toolBar)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        NavigationUI.setupWithNavController(binding.toolbar, navController)
    }

//    Обрабатывае нажатие "Назад" в ActionBar
    override fun onSupportNavigateUp(): Boolean {
    val navController = (supportFragmentManager
        .findFragmentById(R.id.nav_host_fragment) as NavHostFragment)
        .navController
    return navController.navigateUp() || super.onSupportNavigateUp()
    }
}
