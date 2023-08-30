package com.example.bottomnavview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.bottomnavview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()

    }

    private fun initView() {
        val navHost = supportFragmentManager.findFragmentById(R.id.fragmentContainerView3) as NavHostFragment
        binding.bottomNavView.setupWithNavController(navHost.navController)

    }
}
