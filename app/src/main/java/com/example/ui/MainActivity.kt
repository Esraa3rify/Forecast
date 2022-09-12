package com.example.ui

import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationResult
import kotlinx.android.synthetic.main.activity_main.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance
import android.Manifest


private const val MY_PERMISSION_ACCESS_COARSE_LOCATION = 1
class MainActivity : AppCompatActivity(),KodeinAware {
    override val kodein by closestKodein()
    private val fusedLocationProviderClient: FusedLocationProviderClient by instance()

    private val locationCallback = object : LocationCallback() {
        override fun onLocationResult(p0: LocationResult) {
            super.onLocationResult(p0)
        }
    }

//    private val locationCallback = object : LocationCallback() {
//        override fun onLocationResult(p0: LocationResult) {
//            if (p0 != null) {
//                super.onLocationResult(p0)
//            }
//        }
//    }

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

        requestLocationPermission()

        if (hasLocationPermission()) {
            bindLocationManager()
        }
        else
            requestLocationPermission()



    }
  //  override fun onSupportNavigateUp(): Boolean {
     //   return NavigationUI.navigateUp(navController,null)
  //  }

    private fun bindLocationManager() {
        LifecycleBoundLocationManager(
            this,
            fusedLocationProviderClient, locationCallback
        )
    }

    private fun requestLocationPermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION),
            MY_PERMISSION_ACCESS_COARSE_LOCATION
        )
    }


    private fun hasLocationPermission(): Boolean {
        return ContextCompat.checkSelfPermission(this,
            Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == MY_PERMISSION_ACCESS_COARSE_LOCATION) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                bindLocationManager()
            else
                Toast.makeText(this, "Please, set location manually in settings", Toast.LENGTH_LONG).show()
        }
    }


}