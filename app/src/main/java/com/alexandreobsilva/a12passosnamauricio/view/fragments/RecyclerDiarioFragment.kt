package com.alexandreobsilva.a12passosnamauricio.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager

import com.alexandreobsilva.a12passosnamauricio.R
import com.alexandreobsilva.a12passosnamauricio.model.pojos.TextosDoDiario
import com.alexandreobsilva.a12passosnamauricio.model.pojos.listaDozePassosAA
import com.alexandreobsilva.a12passosnamauricio.view.adapter.AdapterDasListas
import com.alexandreobsilva.a12passosnamauricio.view.adapter.AdapterDiario
import kotlinx.android.synthetic.main.fragment_diario.view.*
import kotlinx.android.synthetic.main.fragment_doze_passos_a_a.view.*
import kotlinx.android.synthetic.main.fragment_recycler_diario.view.*

/**
 * A simple [Fragment] subclass.
 */
class RecyclerDiarioFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val minhaView = inflater.inflate(R.layout.fragment_recycler_diario, container, false)

        novoArquivoDiario(minhaView)

//        with(minhaView.recycler_diario) {
//            adapter = AdapterDiario(context, )
//            layoutManager = LinearLayoutManager(
//                context,
//                LinearLayoutManager.VERTICAL,
//                false
//            )
//        }




        return minhaView
    }

                private fun novoArquivoDiario(minhaView: View) {
            minhaView.btn_novoArquivoDiario.setOnClickListener(View.OnClickListener {
                val manager: FragmentManager? = fragmentManager
                val transaction: FragmentTransaction = manager!!.beginTransaction()
                transaction.replace(R.id.nav_host_fragment, DiarioFragment())
                transaction.commit()

            })
        }
}
