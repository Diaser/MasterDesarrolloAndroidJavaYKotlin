package com.mx.monzon.masterdesarrolloandroidjavaykotlin.utils

import android.content.Context
import android.view.Gravity
import android.widget.Toast

class MyUtils {

    companion object {
        fun mostrarToast( context: Context, mensaje: String){
            val toast = Toast.makeText(context, mensaje, Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.CENTER,0,0)
            toast.show()
        }
        val USUARIO: String = "USUARIO"
        val CONTRA: String = "CONTRA"
    }

}