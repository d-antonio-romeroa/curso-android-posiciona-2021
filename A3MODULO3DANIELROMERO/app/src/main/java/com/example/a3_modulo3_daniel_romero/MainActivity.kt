package com.example.a3_modulo3_daniel_romero

import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.widget.EditText
import android.os.Bundle
import com.example.a3_modulo3_daniel_romero.R
import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.Button
import com.example.a3_modulo3_daniel_romero.eur_to_clp
import com.example.a3_modulo3_daniel_romero.MainActivity
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    var totalEur: TextView? = null
    var convertirToEur: Button? = null
    var switchConverterToCLP: Button? = null
    var clpInput: EditText? = null
    var clpFloat = 0.0
    var totalFloatEur = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        convertirToEur = findViewById<View>(R.id.convertir_to_eur) as Button
        clpInput = findViewById<View>(R.id.clp_input) as EditText
        totalEur = findViewById<View>(R.id.total_eur) as TextView
        switchConverterToCLP = findViewById<View>(R.id.switch_converter_btn) as Button
        convertirToEur!!.setOnClickListener {
            if (!clpInput!!.text.toString().trim { it <= ' ' }.isEmpty()) {
                clpFloat = (clpInput!!.text.toString() + "").toDouble()
            } else {
                clpFloat = 1.0
                clpInput!!.setText("1")
            }
            totalFloatEur = clpFloat / 952.57
            val df = DecimalFormat("0.000")
            totalEur!!.text = df.format(totalFloatEur) + ""
        }
    }

    fun switchDivisa(view: View?) {
        val intent = Intent(this, eur_to_clp::class.java)
        val message = clpInput!!.text.toString()
        intent.putExtra(EXTRA_MESSAGE, message)
        startActivity(intent)
        Log.d(LOG_TAG, "Cambio de Convertidor a EUROS")
    }

    companion object {
        private val LOG_TAG: String = MainActivity::class.java.getSimpleName()
        const val EXTRA_MESSAGE = "com.example.a3_modulo3_daniel_romero.extra.MESSAGE"
    }
}