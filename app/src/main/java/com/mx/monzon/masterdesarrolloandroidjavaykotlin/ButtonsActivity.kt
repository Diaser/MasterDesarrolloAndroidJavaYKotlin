package com.mx.monzon.masterdesarrolloandroidjavaykotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import com.mx.monzon.masterdesarrolloandroidjavaykotlin.utils.MyUtils
import timber.log.Timber

class ButtonsActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var btnNormal:Button
    lateinit var btnImgBottom:Button
    lateinit var btnImgTop:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buttons)
        Timber.i("EDMM onCreate")
        MyUtils.mostrarToast(applicationContext, "estamos en ButtonsActivity")

        btnNormal = findViewById(R.id.buttonNormal);
        btnImgBottom = findViewById(R.id.buttonConImgBottom)
        btnImgTop = findViewById(R.id.buttonConImgTop)

        btnNormal.setOnClickListener(View.OnClickListener {
            showToast("Botón normal")
        })

        val imgBtn: ImageButton = findViewById(R.id.imageButton)
        imgBtn.setOnClickListener{
            showToast("Imagen")
        }

        val btnIzq:Button = findViewById(R.id.buttonConImagenIzq)
        btnIzq.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                showToast("Botón con imagen a la izquierda")
            }
        })

        val btnDer:Button =  findViewById(R.id.buttonConImgDerecha)
        btnDer.setOnClickListener(View.OnClickListener { view ->
            showToast("Botón con imagen a la derecha")
        })

        btnImgBottom.setOnClickListener(this)

        btnImgTop.setOnClickListener(listener)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.buttonConImgBottom ->{
                showToast("Botón con imagen abajo")
            }
        }
    }

    val listener= View.OnClickListener { view ->
        when (view.getId()) {
            R.id.buttonConImgTop -> {
                showToast("Botón con imagen arriba")
            }
        }
    }

    fun showToast(message: String){
        val myToast = Toast.makeText(applicationContext,message,Toast.LENGTH_SHORT)
        myToast.setGravity(Gravity.CENTER,0,0)
        myToast.show()
    }
}