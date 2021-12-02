package com.root.a5_modulo4_danielromero

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private val LOG_TAG = MainActivity::class.java.simpleName
    var total_eur: TextView? = null
    var convertir_to_eur: Button? = null
    var switch_converter_to_CLP: Button? = null
    var clp_input: EditText? = null
    var clp_float = 0.0
    var total_float_eur: Double = 0.0
    val EXTRA_MESSAGE = "com.example.a3_modulo3_daniel_romero.extra.MESSAGE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        convertir_to_eur = findViewById<View>(R.id.convertir_to_eur) as Button
        clp_input = findViewById<View>(R.id.clp_input) as EditText
        total_eur = findViewById<View>(R.id.total_eur) as TextView
        switch_converter_to_CLP = findViewById<View>(R.id.switch_converter_btn) as Button

        convertir_to_eur!!.setOnClickListener {
            if (!clp_input!!.text.toString().trim { it <= ' ' }.isEmpty()) {
                clp_float = (clp_input!!.text.toString() + "").toFloat().toDouble()
            } else {
                clp_float = 1.0
                clp_input!!.setText("1")
            }
            total_float_eur = clp_float / 952.57
            val df = DecimalFormat("0.000")
            total_eur!!.text = df.format(total_float_eur) + ""
        }

    }

    fun switchDivisa(view: View?) {
        val intent = Intent(this, eur_to_clp::class.java)
        val message = clp_input!!.text.toString()
        intent.putExtra(EXTRA_MESSAGE, message)
        startActivity(intent)
        Log.d(LOG_TAG, "Cambio de Convertidor a EUROS")
    }

}