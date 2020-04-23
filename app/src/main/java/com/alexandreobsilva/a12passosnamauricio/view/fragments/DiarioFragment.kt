package com.alexandreobsilva.a12passosnamauricio.view.fragments

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.alexandreobsilva.a12passosnamauricio.R
import kotlinx.android.synthetic.main.fragment_diario.view.*
import java.text.SimpleDateFormat
import java.util.*


class DiarioFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val minhaView = inflater.inflate(R.layout.fragment_diario, container, false)

        capturaData(minhaView)
        capturaHora(minhaView)

        
        minhaView.button_diario_salvar.setOnClickListener(View.OnClickListener {

            val toast: Toast = Toast.makeText(context, "salvo com sucesso", Toast.LENGTH_LONG)
            toast.setGravity(Gravity.CENTER_HORIZONTAL or Gravity.CENTER_VERTICAL, 0, 0)
            toast.show()

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
