package com.mx.monzon.masterdesarrolloandroidjavaykotlin

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.mx.monzon.masterdesarrolloandroidjavaykotlin.databinding.ActivityBottomNavNotasBinding
import com.mx.monzon.masterdesarrolloandroidjavaykotlin.utils.MyUtils
import timber.log.Timber

class BottomNavNotasActivity : AppCompatActivity() {

    private lateinit var binding:ActivityBottomNavNotasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomNavNotasBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        Timber.i("EDMM onCreate")
        MyUtils.mostrarToast(applicationContext, "estamos en BottomNavNotasActivity")

        // Get the Intent that started this activity and extract the string
        val message = intent.getStringExtra(MyUtils.USUARIO);
        MyUtils.mostrarToast(applicationContext, "Hola! " + message);
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}