package com.alexandreobsilva.a12passosnamauricio.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.alexandreobsilva.a12passosnamauricio.R
import kotlinx.android.synthetic.main.fragment_orar.view.*
import com.alexandreobsilva.a12passosnamauricio.model.pojos.listaDeOracoes
import com.alexandreobsilva.a12passosnamauricio.view.adapter.AdapterDasListas


class OrarFragment : Fragment() {

    lateinit var adapterDasListas: AdapterDasListas

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val minhaView = inflater.inflate(R.layout.fragment_orar, container, false)

        with(minhaView.recycler_oracoes) {
            adapter = AdapterDasListas(context, listaDeOracoes)
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL,
                false
            )
        }
        return minhaView
    }
}
