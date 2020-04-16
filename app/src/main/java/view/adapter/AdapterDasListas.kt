package view.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alexandreobsilva.a12passosnamauricio.R
import kotlinx.android.synthetic.main.item_recycler.view.*
import model.pojos.PassosTradicoesConceitos
import view.activitys.DetalheActivity

class AdapterDasListas(private val context: Context, private var textoListas: MutableList<PassosTradicoesConceitos>) :
    RecyclerView.Adapter<AdapterDasListas.GameViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterDasListas.GameViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_recycler, parent, false)

        return GameViewHolder(view)
    }

    override fun getItemCount(): Int = textoListas.size

    override fun onBindViewHolder(holder: AdapterDasListas.GameViewHolder, position: Int) {
        holder.bindView(textoListas[position])

    }

    class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val titulo = itemView.titulo_listt_text_view

        fun bindView(passos: PassosTradicoesConceitos) {
            titulo.text = passos.titulo


            itemView.setOnClickListener {
                val intent = Intent(itemView.context,DetalheActivity::class.java)
                intent.putExtra("Key10", passos)
                itemView.context.startActivity(intent)

            }
        }
    }
}