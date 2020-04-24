package com.alexandreobsilva.a12passosnamauricio.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.alexandreobsilva.a12passosnamauricio.R
import com.alexandreobsilva.a12passosnamauricio.model.pojos.listaDozeAmorExigente
import com.alexandreobsilva.a12passosnamauricio.model.pojos.listaDozeConceitos
import com.alexandreobsilva.a12passosnamauricio.view.adapter.AdapterDasListas
import kotlinx.android.synthetic.main.fragment_amor_exigente.view.*
import kotlinx.android.synthetic.main.fragment_dozeconceitos.view.*

class AmorExigenteFragment : Fragment() {

    lateinit var adapterDasListas: AdapterDasListas

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val minhaView = inflater.inflate(R.layout.fragment_amor_exigente, container, false)

        with(minhaView.recycler_amorExigente) {
            adapter = AdapterDasListas(context, listaDozeAmorExigente)
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL,
                false
            )
        }
        return minhaView
    }
}
