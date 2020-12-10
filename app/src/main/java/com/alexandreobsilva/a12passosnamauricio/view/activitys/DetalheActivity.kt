package com.alexandreobsilva.a12passosnamauricio.view.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alexandreobsilva.a12passosnamauricio.R
import kotlinx.android.synthetic.main.activity_detalhe.*
import com.alexandreobsilva.a12passosnamauricio.model.pojos.PassosTradicoesConceitos

class DetalheActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe)

        val recebidos = intent.extras?.getSerializable("Key10") as PassosTradicoesConceitos

        text_view_detalhe_titulo.text = recebidos.titulo
        textViewDes.text = recebidos.textodetalhe

        buttonEntendi.setOnClickListener {
            finish()
        }
    }
}