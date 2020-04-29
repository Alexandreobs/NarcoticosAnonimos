package com.alexandreobsilva.a12passosnamauricio.view.activitys

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.alexandreobsilva.a12passosnamauricio.R
import kotlinx.android.synthetic.main.activity_calculadora.*
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit


class CalculadoraActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        var dataInput = inputDataCalculadora2.text



        buttonCalcular.setOnClickListener(View.OnClickListener {

            val inicialDate = SimpleDateFormat("dd/MM/yyyy").parse(dataInput.toString())
            val diff = getDateDiff(inicialDate, Date(), TimeUnit.DAYS)
            val mes = getDateDiff(inicialDate, Date(), TimeUnit.MILLISECONDS) / (1000*60*60*24) / 29
            val ano = getDateDiff(inicialDate, Date(), TimeUnit.DAYS) / 365


            textResultadoCalculadora.setText(diff.toString() + " Dias de Vitória")
            textResultadoCalculadoraMes.setText(mes.toString() + " Meses de Vitória")
            textResultadoCalculadoraAno.setText(ano.toString() + " Anos de Vitória")

        })


        button_calculadora_voltar.setOnClickListener(View.OnClickListener {
            finish()

        })
    }

    fun getDateDiff(date1: Date, date2: Date, timeUnit: TimeUnit): Long {
        val diffInMillies = date2.time - date1.time
        return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS)
    }

}


