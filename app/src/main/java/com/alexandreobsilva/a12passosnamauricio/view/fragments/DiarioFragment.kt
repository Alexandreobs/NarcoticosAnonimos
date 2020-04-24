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
import com.alexandreobsilva.a12passosnamauricio.model.pojos.TextosDoDiario
import kotlinx.android.synthetic.main.activity_detalhe_diario.*
import kotlinx.android.synthetic.main.fragment_diario.*
import kotlinx.android.synthetic.main.fragment_diario.view.*
import java.text.SimpleDateFormat
import java.util.*


class DiarioFragment : Fragment() {

    private val meubanco: DiarioDAO = MeuDataBaseRoom.getInstance(context!!).diarioDao()

//    val database = databaseBuilder(
//        this,
//        MeuDataBaseRoom::class.java,
//        "nome-da-database")

    val hora = txt_detalhe_diario_hora!!.text.toString()
    val corpo = txt_detalhe_diario_corpo!!.text.toString()
    val data = txt_detalhe_diario_data!!.text.toString()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val minhaView = inflater.inflate(R.layout.fragment_diario, container, false)

        capturaData(minhaView)
        capturaHora(minhaView)

        minhaView.btn_acessar_arquivo_diario.setOnClickListener(View.OnClickListener {
            val manager: FragmentManager? = fragmentManager
            val transaction: FragmentTransaction = manager!!.beginTransaction()
            transaction.replace(R.id.nav_host_fragment, RecyclerDiarioFragment())
            transaction.commit()

        })


        minhaView.button_diario_salvar.setOnClickListener(View.OnClickListener {

            txt_diario_data.text = insereApostaBancoDados().toString()
            txt_diario_hora.text = insereApostaBancoDados().toString()
            txt_detalhe_diario_corpo.text = insereApostaBancoDados().toString()

            Thread(Runnable {
                val evento = TextosDoDiario( )
                if (evento != null) {
                    DiarioDAO.(evento)
                }
            }).start()


            val toast: Toast = Toast.makeText(context, "salvo com sucesso", Toast.LENGTH_LONG)
            toast.setGravity(Gravity.CENTER_HORIZONTAL or Gravity.CENTER_VERTICAL, 0, 0)
            toast.show()

        })


        return minhaView
    }

    fun insereApostaBancoDados(textos: TextosDoDiario) {
        Thread(Runnable {
            if (textos != null) {
                meubanco.insertAll(textos)
            }
        }).start()
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
