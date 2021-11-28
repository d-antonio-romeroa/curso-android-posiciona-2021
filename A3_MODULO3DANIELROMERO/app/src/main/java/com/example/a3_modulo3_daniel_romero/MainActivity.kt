package com.example.a3_modulo3_daniel_romero

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    var total: TextView? = null
    var convertir: Button? = null
    var clp_input: EditText? = null
    var clp_float = 0.0
    var total_float = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        convertir = findViewById<View>(R.id.convetir_btn) as Button
        clp_input = findViewById<View>(R.id.clp_input) as EditText
        total = findViewById<View>(R.id.total) as TextView
        convertir!!.setOnClickListener {
            clp_float = if (clp_input!!.text.toString() != "") {
                (clp_input!!.text.toString() + "").toFloat().toDouble()
            } else {
                0.0
            }
            total_float = clp_float / 952.57
            val df = DecimalFormat("0.00")
            total!!.text = df.format(total_float) + ""
        }
    } //    URL url = new URL("http://www.android.com/");
    //    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
    //   try {
    //        InputStream in = new BufferedInputStream(urlConnection.getInputStream());
    //        readStream(in);
    //    } finally {
    //        urlConnection.disconnect();
    //    }
}