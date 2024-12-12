package com.example.ledger

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
/*this library allows the main activity to connect to data sources in
a declarative format instead of a programmatic format
 */
import com.example.ledger.databinding.ActivityMainBinding

//this is the launch point of the entire app
class MainActivity : AppCompatActivity() {
    //this instantiates the main function
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        /*basically it runs all saved instance of the app
        * plus your code, NEEDS the super class in order for it
        * to function*/
        super.onCreate(savedInstanceState)

        /* the view hierarchy is connected to the main function before it is
        * affected by expressions in the layout*/
        binding = ActivityMainBinding.inflate(layoutInflater)
        //this appears to be the home page
        setContentView(binding.root)

        //the bottom navigation screen
        val navView: BottomNavigationView = binding.navView

        //
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}