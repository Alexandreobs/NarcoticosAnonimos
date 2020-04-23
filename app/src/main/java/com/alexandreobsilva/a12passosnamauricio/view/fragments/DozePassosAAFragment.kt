package com.alexandreobsilva.a12passosnamauricio.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.alexandreobsilva.a12passosnamauricio.R
import com.alexandreobsilva.a12passosnamauricio.model.pojos.listaDozePassos
import com.alexandreobsilva.a12passosnamauricio.model.pojos.listaDozePassosAA
import com.alexandreobsilva.a12passosnamauricio.view.adapter.AdapterDasListas
import kotlinx.android.synthetic.main.fragment_doze_passos_a_a.view.*
import kotlinx.android.synthetic.main.fragment_dozepassos.view.*

class DozePassosAAFragment : Fragment() {

    lateinit var adapterDasListas: AdapterDasListas

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val minhaView = inflater.inflate(R.layout.fragment_doze_passos_a_a, container, false)

        with(minhaView.recycler_dozepassosAA) {
            adapter = AdapterDasListas(context, listaDozePassosAA)
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL,
                false
            )
        }
        return minhaView
    }
}
