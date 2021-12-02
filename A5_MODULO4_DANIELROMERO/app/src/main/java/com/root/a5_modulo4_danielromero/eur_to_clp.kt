package com.root.a5_modulo4_danielromero

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat

class eur_to_clp : AppCompatActivity() {

    private val LOG_TAG = eur_to_clp::class.java.simpleName
    var total_clp: TextView? = null
    var convertir_to_clp: Button? = null
    var eur_input: EditText? = null
    var eur_float = 0.0
    var total_float_clp: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eur_to_clp)
        convertir_to_clp = findViewById<View>(R.id.convertir_to_clp) as Button?
        eur_input = findViewById<View>(R.id.eur_input) as EditText?
        total_clp = findViewById<View>(R.id.total_clp) as TextView?
        val intent: Intent = getIntent()
        val message = intent.getStringExtra(EXTRA_MESSAGE)
        eur_input!!.setText(message)
        convertir_to_clp!!.setOnClickListener {
            if (!eur_input!!.text.toString().trim { it <= ' ' }.isEmpty()) {
                eur_float = (eur_input!!.text.toString() + "").toFloat().toDouble()
            } else {
                eur_float = 1.0
                eur_input!!.setText("1")
            }
            total_float_clp = eur_float * 952.57
            val df = DecimalFormat("0.000")
            total_clp!!.setText(df.format(total_float_clp) + "")
        }
    }

    fun switchDivisa(view: View?) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        Log.d(LOG_TAG, "Cambio de Convertidor a EUROS")
    }

}