package com.example.a3_modulo3_daniel_romero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    TextView total_eur;
    Button convertir_to_eur, switch_converter_to_CLP;
    EditText clp_input;
    double clp_float, total_float_eur = 0;
    public static final String EXTRA_MESSAGE =
            "com.example.a3_modulo3_daniel_romero.extra.MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        convertir_to_eur = (Button) findViewById(R.id.convertir_to_eur);
        clp_input = (EditText) findViewById(R.id.clp_input);
        total_eur = (TextView) findViewById(R.id.total_eur);
        switch_converter_to_CLP = (Button) findViewById(R.id.switch_converter_btn);

        convertir_to_eur.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if (!clp_input.getText().toString().trim().isEmpty()) {
                    clp_float = Float.parseFloat(clp_input.getText()+"");
                } else {
                    clp_float = 1;
                    clp_input.setText("1");
                }

                total_float_eur = clp_float/952.57;
                DecimalFormat df = new DecimalFormat("0.000");

                total_eur.setText(df.format(total_float_eur)+"");

            }
        });

    }

    public void switchDivisa(View view){

        Intent intent = new Intent(this, eur_to_clp.class);
        String message = clp_input.getText().toString();

        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
        Log.d(LOG_TAG, "Cambio de Convertidor a EUROS");

    }




}