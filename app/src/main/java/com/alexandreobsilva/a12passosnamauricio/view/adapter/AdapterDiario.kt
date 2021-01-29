package com.alexandreobsilva.a12passosnamauricio.view.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alexandreobsilva.a12passosnamauricio.R
import com.alexandreobsilva.a12passosnamauricio.model.pojos.TextosDoDiario
import com.alexandreobsilva.a12passosnamauricio.view.activitys.DetalheDiarioActivity
import kotlinx.android.synthetic.main.item_recycler_diario.view.*

class AdapterDiario (private val context: Context, private var textoListas: MutableList<TextosDoDiario>) :
    RecyclerView.Adapter<AdapterDiario.AnotacaoDiarioViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterDiario.AnotacaoDiarioViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_recycler_diario, parent, false)

        return AnotacaoDiarioViewHolder(view)
    }

    override fun getItemCount(): Int = textoListas.size

    override fun onBindViewHolder(holder: AdapterDiario.AnotacaoDiarioViewHolder, position: Int) {
        holder.bindView(textoListas[position])

    }

    class AnotacaoDiarioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val corpo = itemView.txt_recycler_previa
        val data = itemView.txt_recycler_data
        val hora = itemView.txt_recycler_hora

        fun bindView(textos: TextosDoDiario) {
            corpo.text = textos.comrpoDoTexto
            data.text = textos.dataDoTexto
            hora.text = textos.horaDoTexto

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetalheDiarioActivity::class.java)
                intent.putExtra("Key10", textos)
                itemView.context.startActivity(intent)

            }
        }
    }
}