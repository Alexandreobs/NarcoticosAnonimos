package com.alexandreobsilva.a12passosnamauricio.view.fragments

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.alexandreobsilva.a12passosnamauricio.R
import com.alexandreobsilva.a12passosnamauricio.model.data.DiarioDAO
import com.alexandreobsilva.a12passosnamauricio.model.data.MeuDataBaseRoom
import com.alexandreobsilva.a12passosnamauricio.model.data.repositorys.RoomRepositorory
import com.alexandreobsilva.a12passosnamauricio.model.pojos.TextosDoDiario
import kotlinx.android.synthetic.main.fragment_diario.*
import kotlinx.android.synthetic.main.fragment_diario.view.*
import java.text.SimpleDateFormat
import java.util.*


class DiarioFragment : Fragment() {

    private val repository: RoomRepositorory by lazy {
        RoomRepositorory(MeuDataBaseRoom.getDatabase(requireContext()))
    }

    lateinit var diarioDAO: DiarioDAO
    private var textodiario: TextosDoDiario? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val minhaView = inflater.inflate(R.layout.fragment_diario, container, false)

        capturaData(minhaView)
        capturaHora(minhaView)

        minhaView.button_diario_salvar.setOnClickListener(View.OnClickListener {
            textodiario = TextosDoDiario()

            textodiario?.comrpoDoTexto = conteudo.text.toString()
            textodiario?.dataDoTexto = txt_diario_data.text.toString()
            textodiario?.horaDoTexto = txt_diario_hora.text.toString()

            textodiario?.let { repository.save(it) }

            Toast.makeText(context, "salvo com sucesso", Toast.LENGTH_LONG).show()

            val manager: FragmentManager? = fragmentManager
            val transaction: FragmentTransaction = manager!!.beginTransaction()
            transaction.replace(R.id.nav_host_fragment, RecyclerDiarioFragment())
            transaction.commit()
        })

        return minhaView
    }



    private fun capturaHora(minhaView: View) {
        val hora = Date().time
        val formataHora = SimpleDateFormat("HH:mm")
        val horaFormatada = formataHora.format(hora)
        minhaView.txt_diario_hora.setText(horaFormatada)
    }

    private fun capturaData(minhaView: View) {
        val date = Date()
        val formataData = SimpleDateFormat("dd/MM/yyyy")
        val dataFormatada = formataData.format(date)
        minhaView.txt_diario_data.setText(dataFormatada)
    }

}
