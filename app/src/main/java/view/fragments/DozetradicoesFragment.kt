package view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.alexandreobsilva.a12passosnamauricio.R
import kotlinx.android.synthetic.main.fragment_dozetradicoes.view.*
import model.pojos.listaDozeTradicoes
import view.adapter.AdapterDasListas


class DozetradicoesFragment : Fragment() {

    lateinit var adapterDasListas: AdapterDasListas

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val minhaView = inflater.inflate(R.layout.fragment_dozetradicoes, container, false)

        with(minhaView.recycler_dozetradicoes) {
            adapter = AdapterDasListas(context, listaDozeTradicoes)
            layoutManager = LinearLayoutManager(
                    context,
                    LinearLayoutManager.VERTICAL,
                    false
                )
        }
        return minhaView
    }
}
