package com.alexandreobsilva.a12passosnamauricio.view.activitys

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alexandreobsilva.a12passosnamauricio.R
import com.alexandreobsilva.a12passosnamauricio.model.pojos.TextosDoDiario
import kotlinx.android.synthetic.main.activity_detalhe_diario.*

class DetalheDiarioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe_diario)

        val recebidos = intent.extras?.getSerializable("Key10") as TextosDoDiario

        txt_detalhe_diario_corpo.text = recebidos.comrpoDoTexto
        txt_detalhe_diario_data.text = recebidos.dataDoTexto
        txt_detalhe_diario_hora.text = recebidos.horaDoTexto
    }
}
