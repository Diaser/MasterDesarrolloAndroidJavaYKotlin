package com.mx.monzon.masterdesarrolloandroidjavaykotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import com.mx.monzon.masterdesarrolloandroidjavaykotlin.utils.MyUtils
import timber.log.Timber

class RadioButtonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio_button)
        Timber.i("EDMM onCreate")
        MyUtils.mostrarToast(applicationContext, "estamos en RadioButtonActivity")
    }

    fun sexoSeleccionado(view: View) {
        val radioBtn = view as RadioButton
        when(view.id){
            R.id.radioBtnHombre -> {
                Toast.makeText(applicationContext,"Se selecciono Hombre", Toast.LENGTH_SHORT).show();
            }
            R.id.radioBtnMujer -> {
                Toast.makeText(applicationContext,"Se selecciono Mujer", Toast.LENGTH_SHORT).show();
            }
            R.id.radioBtnIndefinido -> {
                Toast.makeText(applicationContext,"Se selecciono Indefinido", Toast.LENGTH_SHORT).show();
            }
        }
    }
}