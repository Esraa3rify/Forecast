package com.example.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



     //   navController = Navigation.findNavController(this, R.id.nav_host_fragment)

     //   bottom_nav.setupWithNavController(navController)



        //Here is the error
        Log.d("Error","Error")

        //NavigationUI.setupActionBarWithNavController(this, navController)
       // setSupportActionBar(findViewById(R.id.toolbar))


        setSupportActionBar(toolbar)

        val navController = findNavController(R.id.nav_host_fragment)
        setupActionBarWithNavController(navController)

        bottom_nav.setupWithNavController(navController)



    }
  //  override fun onSupportNavigateUp(): Boolean {
     //   return NavigationUI.navigateUp(navController,null)
  //  }


}