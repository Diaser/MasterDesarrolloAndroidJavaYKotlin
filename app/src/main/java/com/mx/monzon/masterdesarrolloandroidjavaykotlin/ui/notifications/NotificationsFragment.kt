package com.mx.monzon.masterdesarrolloandroidjavaykotlin.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.mx.monzon.masterdesarrolloandroidjavaykotlin.R
import com.mx.monzon.masterdesarrolloandroidjavaykotlin.databinding.FragmentNotificationsBinding
import com.mx.monzon.masterdesarrolloandroidjavaykotlin.utils.MyUtils
import timber.log.Timber

class NotificationsFragment : Fragment() {
    lateinit var binding : FragmentNotificationsBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotificationsBinding.inflate(inflater, container, false )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.i("EDMM onCreate")
        MyUtils.mostrarToast(requireContext(), "estamos en NotificationsFragment")
        val planetArrays = resources.getStringArray(R.array.planets)
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line,planetArrays)
        binding.autoCompleteTextView.setAdapter(adapter)
        binding.autoCompleteTextView.setText(adapter.getItem(0).toString(),false)

        binding.autoCompleteTextView.onItemClickListener = AdapterView.OnItemClickListener {
            parent, view, position, id ->
            val selectedItemText = parent.getItemAtPosition(position)
            Toast.makeText(context,"valor : " + selectedItemText, Toast.LENGTH_SHORT).show()
        }

        binding.button.setOnClickListener(View.OnClickListener {
            var value = "";
            value = binding.autoCompleteTextView.text.toString()
            Toast.makeText(context,"valor : " + value, Toast.LENGTH_SHORT).show()

        })
    }
}