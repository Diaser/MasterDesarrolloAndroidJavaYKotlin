package com.mx.monzon.masterdesarrolloandroidjavaykotlin.ui.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.mx.monzon.masterdesarrolloandroidjavaykotlin.BottomNavNotasActivity
import com.mx.monzon.masterdesarrolloandroidjavaykotlin.databinding.ActivityMainBinding
import com.mx.monzon.masterdesarrolloandroidjavaykotlin.utils.MyUtils
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Timber.i("EDMM onCreate")
        MyUtils.mostrarToast(applicationContext, "estamos en MainActivity")

        binding.btnAceptar.setOnClickListener(View.OnClickListener {
            if(binding.editEmail.text.toString() != null && !binding.editTextPassword.text.toString().trim().equals("")){
                val intent = Intent(this, BottomNavNotasActivity::class.java).apply {
                    putExtra(MyUtils.USUARIO, binding.editEmail.text.toString().trim())
                }
                startActivity(intent)
            }else
                MyUtils.mostrarToast(applicationContext, "Los campos mostrados son obligatorios")


        })
    }
}