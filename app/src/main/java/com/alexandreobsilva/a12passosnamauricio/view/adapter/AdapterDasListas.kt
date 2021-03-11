package com.alexandreobsilva.a12passosnamauricio.view.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alexandreobsilva.a12passosnamauricio.R
import com.alexandreobsilva.a12passosnamauricio.model.pojos.PassosTradicoesConceitos
import com.alexandreobsilva.a12passosnamauricio.view.activitys.DetalheActivity
import kotlinx.android.synthetic.main.item_recycler.view.*

class AdapterDasListas(private val context: Context, private var textoListas: MutableList<PassosTradicoesConceitos>) :
    RecyclerView.Adapter<AdapterDasListas.ListasViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterDasListas.ListasViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_recycler, parent, false)

        return ListasViewHolder(view)
    }

    override fun getItemCount(): Int = textoListas.size

    override fun onBindViewHolder(holder: AdapterDasListas.ListasViewHolder, position: Int) {
        holder.bindView(textoListas[position])
    }

    class ListasViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val titulo = itemView.titulo_listt_text_view

        fun bindView(passos: PassosTradicoesConceitos) {
            titulo.text = passos.titulo

            itemView.setOnClickListener {
                val intent = Intent(itemView.context,DetalheActivity::class.java)
                intent.putExtra("chaveDoAdapter", passos)
                itemView.context.startActivity(intent)
            }
        }
    }
}