package com.alexandreobsilva.a12passosnamauricio.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.alexandreobsilva.a12passosnamauricio.R
import kotlinx.android.synthetic.main.fragment_menu_de_textos.view.*


@Suppress("UNREACHABLE_CODE")
class MenuDeTextosFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val minhaView = inflater.inflate(R.layout.fragment_menu_de_textos, container, false)

        minhaView.button_doze_passos.setOnClickListener(View.OnClickListener {
            val manager: FragmentManager? = fragmentManager
            val transaction: FragmentTransaction = manager!!.beginTransaction()
            transaction.replace(R.id.nav_host_fragment, DozePassosFragment())
            transaction.commit()
        })

        minhaView.button_doze_conceitos.setOnClickListener(View.OnClickListener {
            val manager: FragmentManager? = fragmentManager
            val transaction: FragmentTransaction = manager!!.beginTransaction()
            transaction.replace(R.id.nav_host_fragment, DozeConceitosFragment())
            transaction.commit()
        })

        minhaView.button_doze_tradicoes.setOnClickListener(View.OnClickListener {
            val manager: FragmentManager? = fragmentManager
            val transaction: FragmentTransaction = manager!!.beginTransaction()
            transaction.replace(R.id.nav_host_fragment, DozeTradicoesFragment())
            transaction.commit()
        })

        minhaView.button_oracoes.setOnClickListener(View.OnClickListener {
            val manager: FragmentManager? = fragmentManager
            val transaction: FragmentTransaction = manager!!.beginTransaction()
            transaction.replace(R.id.nav_host_fragment, OrarFragment())
            transaction.commit()
        })

        minhaView.button_doze_recaidas.setOnClickListener(View.OnClickListener {
            val manager: FragmentManager? = fragmentManager
            val transaction: FragmentTransaction = manager!!.beginTransaction()
            transaction.replace(R.id.nav_host_fragment, DozePassosRecaidaFragment())
            transaction.commit()
        })

        minhaView.button_doze_passos_AA.setOnClickListener(View.OnClickListener {
            val manager: FragmentManager? = fragmentManager
            val transaction: FragmentTransaction = manager!!.beginTransaction()
            transaction.replace(R.id.nav_host_fragment, DozePassosAAFragment())
            transaction.commit()
        })

        minhaView.button_amorExigente.setOnClickListener(View.OnClickListener {
            val manager: FragmentManager? = fragmentManager
            val transaction: FragmentTransaction = manager!!.beginTransaction()
            transaction.replace(R.id.nav_host_fragment, AmorExigenteFragment())
            transaction.commit()
        })

        return minhaView
    }

}
