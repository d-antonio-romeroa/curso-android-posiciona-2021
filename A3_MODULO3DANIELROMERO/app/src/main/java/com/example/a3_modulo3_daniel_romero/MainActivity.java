package com.example.a3_modulo3_daniel_romero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    TextView total;
    Button convertir;
    EditText clp_input;
    double clp_float, total_float = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        convertir = (Button) findViewById(R.id.convetir_btn);
        clp_input = (EditText) findViewById(R.id.clp_input);
        total = (TextView) findViewById(R.id.total);

        convertir.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (!clp_input.getText().equals("")) {
                    clp_float = Float.parseFloat(clp_input.getText()+"");
                } else {
                    clp_float = 0;
                }

                total_float = clp_float/952.57;
                DecimalFormat df = new DecimalFormat("0.00");

                total.setText(df.format(total_float)+"");

            }
        });
    }

//    URL url = new URL("http://www.android.com/");
//    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//   try {
//        InputStream in = new BufferedInputStream(urlConnection.getInputStream());
//        readStream(in);
//    } finally {
//        urlConnection.disconnect();
//    }


}