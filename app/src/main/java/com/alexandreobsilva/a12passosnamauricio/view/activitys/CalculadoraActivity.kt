package com.alexandreobsilva.a12passosnamauricio.view.activitys

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.alexandreobsilva.a12passosnamauricio.R
import kotlinx.android.synthetic.main.activity_calculadora.*
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit


class CalculadoraActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        var dataAtual = pegaDataAtual()
        var dataInput = inputDataCalculadora2.text







        buttonCalcular.setOnClickListener(View.OnClickListener {

            val inicialDate = SimpleDateFormat("dd/MM/yyyy").parse(dataInput.toString())
            val diff = getDateDiff(inicialDate, Date(), TimeUnit.DAYS)
            textResultadoCalculadora.setText(diff.toString())

        })


        button_calculadora_voltar.setOnClickListener(View.OnClickListener {
            finish()

        })
    }

    fun getDateDiff(date1: Date, date2: Date, timeUnit: TimeUnit): Long {
        val diffInMillies = date2.time - date1.time
        return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS)
    }

    private fun pegaDataAtual(): String {
        val date = Date()
        val formataData = SimpleDateFormat("dd/MM/yyyy")
        val dataAtual = formataData.format(date)
        return dataAtual
    }

}


