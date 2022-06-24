package com.mx.monzon.masterdesarrolloandroidjavaykotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.Toast
import com.mx.monzon.masterdesarrolloandroidjavaykotlin.utils.MyUtils
import timber.log.Timber

class CheckBoxActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_box)
        Timber.i("EDMM onCreate")
        MyUtils.mostrarToast(applicationContext, "estamos en CheckBoxActivity")
    }

    fun coloresUsuario(view: View) {
        val checBox : CheckBox = view as CheckBox
        val isActive : Boolean =  checBox.isChecked

        when(view.id) {
            R.id.chBoxAzul ->{
                if(isActive)
                    Toast.makeText(applicationContext,"Se a marcado Azul", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(applicationContext,"Se a desmarcado Azul", Toast.LENGTH_SHORT).show();
            }
            R.id.chBoxRojo ->{
                if(isActive)
                    Toast.makeText(applicationContext,"Se a marcado Rojo", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(applicationContext,"Se a desmarcado Rojo", Toast.LENGTH_SHORT).show();
            }
        }
    }
}