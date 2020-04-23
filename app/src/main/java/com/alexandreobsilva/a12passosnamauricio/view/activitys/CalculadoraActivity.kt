package com.alexandreobsilva.a12passosnamauricio.view.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.alexandreobsilva.a12passosnamauricio.R
import kotlinx.android.synthetic.main.activity_calculadora.*

class CalculadoraActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        button_calculadora_voltar.setOnClickListener(View.OnClickListener {
            finish()

        })
    }
}
