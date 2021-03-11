package com.alexandreobsilva.a12passosnamauricio.view.activitys

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import android.view.Gravity
import android.widget.Button
import android.widget.DatePicker
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.alexandreobsilva.a12passosnamauricio.R
import com.alexandreobsilva.a12passosnamauricio.model.data.repositorys.SharedPreferencesClient
import kotlinx.android.synthetic.main.activity_calculadora.*
import org.joda.time.*
import org.joda.time.format.DateTimeFormat
import java.util.*

class CalculadoraActivity : AppCompatActivity() {

    lateinit var mCustomTitleDate: Button
    lateinit var sharedPreferencesClient: SharedPreferencesClient
    var minicialdate: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        mCustomTitleDate = findViewById(R.id.buttonPegaData)

        mCustomTitleDate.setOnClickListener {
            val fragment: DialogFragment = CustomDatePickerFragment()
            fragment.show(supportFragmentManager, "Data Picker")
        }

        buttonCalcular.setOnClickListener { calcular() }
        button_calculadora_voltar.setOnClickListener { finish() }

        sharedPreferencesClient = SharedPreferencesClient(this)
        minicialdate = sharedPreferencesClient.getString("dataInicial")
        minicialdate?.takeIf {it.isNotEmpty()}?.let {
            inputDataCalculadora2.setText(minicialdate)
            calcular()
        }
    }

    private fun calcular() {

        val dataInicial = inputDataCalculadora2.text.toString()
        sharedPreferencesClient.setString("dataInicial", dataInicial)

        val formatter = DateTimeFormat.forPattern("dd/MM/yyyy")
        val dataInicialDate = formatter.parseLocalDate(dataInicial) ?: return
        val dataFinalDate = LocalDate()

        val dias = Days.daysBetween(dataInicialDate, dataFinalDate).days
        val semanas = Weeks.weeksBetween(dataInicialDate, dataFinalDate).weeks
        val meses = Months.monthsBetween(dataInicialDate, dataFinalDate).months
        val anos = Years.yearsBetween(dataInicialDate, dataFinalDate).years

        textResultadoCalculadoraDias.text = resources.getQuantityString(R.plurals.dias_vitoria, dias, dias)
        textResultadoCalculadoraSemanas.text = resources.getQuantityString(R.plurals.semanas_vitoria, semanas, semanas)
        textResultadoCalculadoraMes.text = resources.getQuantityString(R.plurals.meses_vitoria, meses, meses)
        textResultadoCalculadoraAno.text = resources.getQuantityString(R.plurals.anos_vitoria, anos, anos)
    }

    class CustomDatePickerFragment : DialogFragment(), DatePickerDialog.OnDateSetListener {
        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

            val calendar: Calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                requireContext(),
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


