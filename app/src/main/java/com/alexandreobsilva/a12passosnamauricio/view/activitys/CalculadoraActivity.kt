package com.alexandreobsilva.a12passosnamauricio.view.activitys

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.alexandreobsilva.a12passosnamauricio.R
import kotlinx.android.synthetic.main.activity_calculadora.*

class CalculadoraActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        button_calculadora_voltar.setOnClickListener(View.OnClickListener {
            finish()

           var aa = inputDataCalculadora2.editableText

            buttonCalcular.setOnClickListener(View.OnClickListener {
                textResultadoCalculadora.setText(aa)
            })

        })
    }

}
