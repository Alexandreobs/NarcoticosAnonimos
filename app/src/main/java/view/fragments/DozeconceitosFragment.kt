package view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.alexandreobsilva.a12passosnamauricio.R
import kotlinx.android.synthetic.main.fragment_dozeconceitos.view.*
import model.pojos.listaDozeConceitos
import view.adapter.AdapterDasListas


class DozeconceitosFragment : Fragment() {

    lateinit var adapterDasListas: AdapterDasListas

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val minhaView = inflater.inflate(R.layout.fragment_dozeconceitos, container, false)

        with(minhaView.recycler_dozeconceitos) {
            adapter = AdapterDasListas(context, listaDozeConceitos)
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL,
                false
            )
        }
        return minhaView
    }
}
