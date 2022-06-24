package com.mx.monzon.masterdesarrolloandroidjavaykotlin.ui.views.fragments

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.mx.monzon.masterdesarrolloandroidjavaykotlin.R
import com.mx.monzon.masterdesarrolloandroidjavaykotlin.to.Notas


class MyAdapterNotas(
        private val values: List<Notas>)
    : RecyclerView.Adapter<MyAdapterNotas.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val nota = values[position]
        holder.mNota = nota
        holder.tvTitulo.text = holder.mNota.titulo
        holder.tvTexto.text = holder.mNota.contenido
        if(holder.mNota.favorita)
            holder.imgFavorite.setImageResource(R.drawable.start_fill)
        if(holder.mNota.color!=0)
            holder.itemView.setBackgroundResource(holder.mNota.color)
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTitulo: TextView = view.findViewById(R.id.tvTitulo)
        val tvTexto: TextView = view.findViewById(R.id.tvTexto)
        val imgFavorite: ImageView = view.findViewById(R.id.imgFavorite)
        lateinit var mNota : Notas

        override fun toString(): String {
            return super.toString() + " '" + tvTitulo.text + "'"
        }
    }
}