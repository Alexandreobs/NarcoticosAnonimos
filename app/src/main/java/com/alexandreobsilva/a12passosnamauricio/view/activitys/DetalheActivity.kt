package com.alexandreobsilva.a12passosnamauricio.view.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alexandreobsilva.a12passosnamauricio.R
import kotlinx.android.synthetic.main.activity_detalhe.*
import com.alexandreobsilva.a12passosnamauricio.model.pojos.PassosTradicoesConceitos

class DetalheActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe)

        recebeOsTextos()

        buttonEntendi.setOnClickListener { finish() }
        btn_compartilhar.setOnClickListener { copartilharTextos() }
    }

    fun recebeOsTextos(){
        val recebidos = intent.extras?.getSerializable("chaveDoAdapter") as PassosTradicoesConceitos
        text_view_detalhe_titulo.text = recebidos.titulo
        textViewDes.text = recebidos.textodetalhe
    }

    fun copartilharTextos() {
      val recebidos = intent.extras?.getSerializable("chaveDoAdapter") as PassosTradicoesConceitos
        val text1 = recebidos.textodetalhe
        val text2 = recebidos.titulo

        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "Texto compartilhado atrávez do app Vitória Anônima\n\n feito por https://www.linkedin.com/in/alexandreobs/\n\n" +
                  text2 + "\n\n" + text1 )
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }
}



