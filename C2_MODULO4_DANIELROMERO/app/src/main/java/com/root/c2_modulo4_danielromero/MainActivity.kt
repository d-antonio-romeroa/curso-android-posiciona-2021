package com.root.c2_modulo4_danielromero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var total: TextView? = null
    var sumBtn: Button? = null
    var restaBtn: Button? = null
    var multBtn: Button? = null
    var divBtn: Button? = null
    var cifra01: EditText? = null
    var cifra02: EditText? = null
    var c1Float = 0.0
    var c2Float = 0.0
    var totalFloat = 0.0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        total = findViewById<View>(R.id.total_out) as TextView
        sumBtn = findViewById<View>(R.id.sum_btn) as Button
        restaBtn = findViewById<View>(R.id.resta_btn) as Button
        multBtn = findViewById<View>(R.id.mult_btn) as Button
        divBtn = findViewById<View>(R.id.div_btn) as Button
        cifra01 = findViewById<View>(R.id.c1_in) as EditText
        cifra02 = findViewById<View>(R.id.c2_in) as EditText

        sumBtn!!.setOnClickListener {
            if ( !cifra01!!.text.toString().trim { it <= ' '}.isEmpty()) {
                c1Float = (cifra01!!.text.toString() + "").toDouble()
            } else {
                c1Float = 0.0
                cifra01!!.setText("0")
            }
            if ( !cifra02!!.text.toString().trim { it <= ' '}.isEmpty()) {
                c2Float = (cifra02!!.text.toString() + "").toDouble()
            } else {
                c2Float = 0.0
                cifra02!!.setText("0")
            }

            totalFloat = c1Float + c2Float
            total!!.text = totalFloat.toString() + ""

        }

        restaBtn!!.setOnClickListener {
            if ( !cifra01!!.text.toString().trim { it <= ' '}.isEmpty()) {
                c1Float = (cifra01!!.text.toString() + "").toDouble()
            } else {
                c1Float = 0.0
                cifra01!!.setText("0")
            }
            if ( !cifra02!!.text.toString().trim { it <= ' '}.isEmpty()) {
                c2Float = (cifra02!!.text.toString() + "").toDouble()
            } else {
                c2Float = 0.0
                cifra02!!.setText("0")
            }

            totalFloat = c1Float - c2Float
            total!!.text = totalFloat.toString() + ""

        }

        multBtn!!.setOnClickListener {
            if ( !cifra01!!.text.toString().trim { it <= ' '}.isEmpty()) {
                c1Float = (cifra01!!.text.toString() + "").toDouble()
            } else {
                c1Float = 0.0
                cifra01!!.setText("0")
            }
            if ( !cifra02!!.text.toString().trim { it <= ' '}.isEmpty()) {
                c2Float = (cifra02!!.text.toString() + "").toDouble()
            } else {
                c2Float = 0.0
                cifra02!!.setText("0")
            }

            totalFloat = c1Float * c2Float
            total!!.text = totalFloat.toString() + ""

        }

        divBtn!!.setOnClickListener {
            if ( !cifra01!!.text.toString().trim { it <= ' '}.isEmpty()) {
                c1Float = (cifra01!!.text.toString() + "").toDouble()
            } else {
                c1Float = 1.0
                cifra01!!.setText("1")
            }
            if ( !cifra02!!.text.toString().trim { it <= ' '}.isEmpty()) {
                c2Float = (cifra02!!.text.toString() + "").toDouble()
            } else {
                c2Float = 1.0
                cifra02!!.setText("1")
            }

            totalFloat = c1Float / c2Float
            total!!.text = totalFloat.toString() + ""

        }
    }

//    fun sumar(view: View?){
//        val result = cifra_01!!.text.toString().toInt() + cifra_02!!.text.toString().toInt()
//        resultado!!.text = result.toString() + ""
//        Log.d("operacionSuma", "Boton suma apretado")
//    }
}