package com.alexandreobsilva.a12passosnamauricio.view.activitys

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.Dialog
import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.alexandreobsilva.a12passosnamauricio.R
import kotlinx.android.synthetic.main.activity_calculadora.*
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit


class CalculadoraActivity : AppCompatActivity() {

    lateinit var mCustomTitleDate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)


        var dataInput = inputDataCalculadora2.text


        mCustomTitleDate = findViewById(R.id.buttonPegaData)
        mCustomTitleDate.setOnClickListener(View.OnClickListener {
            val fragment: DialogFragment = CustomDatePickerFragment()
            fragment.show(supportFragmentManager, "Data Picker")
        })

        buttonCalcular.setOnClickListener(View.OnClickListener {

            val inicialDate = SimpleDateFormat("dd/MM/yyyy").parse(dataInput.toString())

            val diff = getDateDiff(inicialDate, Date(), TimeUnit.DAYS)
            val mes =
                getDateDiff(inicialDate, Date(), TimeUnit.MILLISECONDS) / (1000 * 60 * 60 * 24) / 29
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

    class CustomDatePickerFragment : DialogFragment(), DatePickerDialog.OnDateSetListener {
        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

            val calendar: Calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                requireContext(),
                AlertDialog.THEME_HOLO_LIGHT,
                this,
                year,
                month,
                day
            )

            val textView = TextView(activity)

            val layoutParams = RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
            )

            textView.layoutParams = layoutParams
            textView.setPadding(20, 20, 20, 20)
            textView.gravity = Gravity.CENTER
            textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25f)
            textView.setText("Seleção de Data")
            textView.setTextColor(Color.parseColor("#ffffff"))
            textView.setBackgroundColor(Color.parseColor("#5412DC"))

            datePickerDialog.setCustomTitle(textView)



            return datePickerDialog
        }

        override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMoth: Int) {

            val builder = AlertDialog.Builder(requireContext())
            builder.apply {
                setPositiveButton(R.string.texto_OK,
                    DialogInterface.OnClickListener { dialog, id ->
                        // User clicked OK button
                    })

            }
        }
    }
}


