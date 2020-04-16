package view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.alexandreobsilva.a12passosnamauricio.R
import kotlinx.android.synthetic.main.fragment_doze_passos_recaida.view.*
import kotlinx.android.synthetic.main.fragment_dozepassos.view.*
import model.pojos.listaDeRecaidas
import view.adapter.AdapterDasListas


class DozePassosRecaidaFragment : Fragment() {

    lateinit var adapterDasListas: AdapterDasListas

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val minhaView = inflater.inflate(R.layout.fragment_doze_passos_recaida, container, false)

        with(minhaView.recycler_dozepassosRecaida) {
            adapter = AdapterDasListas(context, listaDeRecaidas)
            layoutManager = androidx.recyclerview.widget.LinearLayoutManager(
                context,
                androidx.recyclerview.widget.LinearLayoutManager.VERTICAL,
                false
            )
        }
        return minhaView
    }
}
