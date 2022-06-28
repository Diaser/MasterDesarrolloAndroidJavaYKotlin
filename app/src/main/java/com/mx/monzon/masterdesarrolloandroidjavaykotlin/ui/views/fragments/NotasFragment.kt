package com.mx.monzon.masterdesarrolloandroidjavaykotlin.ui.views.fragments

import android.os.Bundle
import android.util.DisplayMetrics
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.mx.monzon.masterdesarrolloandroidjavaykotlin.R
import com.mx.monzon.masterdesarrolloandroidjavaykotlin.to.Notas

/**
 * A fragment representing a list of Items.
 */
class NotasFragment : Fragment() {

    private var columnCount = 2
    var listaNotas:MutableList<Notas> = mutableListOf()
    val displayMetrics = DisplayMetrics()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_item_list, container, false)

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
            val display = requireActivity().display
            display?.getRealMetrics(displayMetrics)
        }else{
            @Suppress("DEPRECATION")
            val display = requireActivity().windowManager.defaultDisplay
            @Suppress("DEPRECATION")
            display.getMetrics(displayMetrics)
        }

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> {

                        val ancho:Float = displayMetrics.widthPixels/displayMetrics.density
                        val numColumns:Int = (ancho/180).toInt()
                        StaggeredGridLayoutManager(numColumns, StaggeredGridLayoutManager.VERTICAL)
                    }
                }
                fillList();
                adapter = MyAdapterNotas(listaNotas)
            }
        }
        return view
    }

    companion object {
        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
                NotasFragment().apply {
                    arguments = Bundle().apply {
                        putInt(ARG_COLUMN_COUNT, columnCount)
                    }
                }
    }

    fun fillList(){
        listaNotas.add(Notas("Mensaje de Mamá", "Hola, vendrás a comer?",true,R.color.amarillo_oro))
        listaNotas.add(Notas("Alexa", "Ya deja de estar chingando", false, R.color.naranja_oxidado))
        listaNotas.add(Notas("Wikipedia","Hola, lector/a en México:\n" +
                "Por favor, no ignores este mensaje. Este jueves, te pedimos que apoyes la independencia de Wikipedia. Gracias al 2% de lectores y lectoras que donan, Wikipedia permanece accesible para todos y todas. Si donas 40 MXN, o lo que puedas, " +
                "Wikipedia puede seguir creciendo. La mayoría de las personas donan porque Wikipedia es útil. Si tú también piensas eso, plantéate hacer una donación de 40 MXN. Muéstrale al mundo que el acceso a información neutral y confiable es importante para ti. Si eres uno/a de nuestros/as donantes excepcionales, tienes nuestro reconocimiento, y te lo agradecemos sinceramente. " +
                "Tu donación es importante.", false, R.color.verde_limon))
        listaNotas.add(Notas("Mensaje de ESport", "Partido de Real madrid queda cero a cero contra el Manchester City" +
                "Eventos populares\n" +
                "\n" +
                "Boletos FC Barcelona, Boletos Real Madrid, Boletos Michael Bublé, Boletos Gira Elton JohnBoletos AC Milán",false,R.color.rojo_amor))
        listaNotas.add(Notas("Rosa Isela", "Perdón si no conteste estaba ocupada, si me ocupe en meses", true, R.color.azul_cielo))
        listaNotas.add(Notas("Mensaje de MensClub", "Promoción de mes, invita a un amigo una semana y el tendrá la semana gratis y tu tendrás un fabuloso 20% de descuento en ese mes. valido solo por 1 amistad",false,R.color.purpura_uva))

    }
}