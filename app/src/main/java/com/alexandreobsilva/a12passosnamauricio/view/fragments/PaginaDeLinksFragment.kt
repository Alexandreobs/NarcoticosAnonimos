package com.alexandreobsilva.a12passosnamauricio.view.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alexandreobsilva.a12passosnamauricio.R
import kotlinx.android.synthetic.main.fragment_pagina_de_links.view.*


class PaginaDeLinksFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

      val minhaView = inflater.inflate(R.layout.fragment_pagina_de_links, container, false)

        minhaView.button_link_Na.setOnClickListener(View.OnClickListener {
            iniciaWeb("https://www.na.org.br/")
        })

        minhaView.button_linkAA.setOnClickListener(View.OnClickListener {
            iniciaWeb("https://www.aa.org.br/")
        })

        minhaView.button_link_cvv.setOnClickListener(View.OnClickListener {
            iniciaWeb("https://www.cvv.org.br/")
        })

        minhaView.button_link_amor.setOnClickListener(View.OnClickListener {
            iniciaWeb("http://amorexigente.org.br/")
        })

        return minhaView
    }

    private fun iniciaWeb(url: String) {
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        startActivity(i)
    }
}
