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

public class eur_to_clp extends AppCompatActivity {

    private static final String LOG_TAG = eur_to_clp.class.getSimpleName();
    TextView total_clp;
    Button convertir_to_clp, switch_converter_to_EUR;
    EditText eur_input;
    double eur_float, total_float_clp = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eur_to_clp);

        convertir_to_clp = (Button) findViewById(R.id.convertir_to_clp);
        eur_input = (EditText) findViewById(R.id.eur_input);
        total_clp = (TextView) findViewById(R.id.total_clp);
//        switch_converter_to_EUR = (Button) findViewById(R.id.switch_converter_btn_2);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        eur_input.setText(message);

        convertir_to_clp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if (!eur_input.getText().toString().trim().isEmpty()) {
                    eur_float = Float.parseFloat(eur_input.getText()+"");
                } else {
                    eur_float = 1;
                    eur_input.setText("1");
                }

                total_float_clp = eur_float*952.57;
                DecimalFormat df = new DecimalFormat("0.000");

                total_clp.setText(df.format(total_float_clp)+"");

            }
        });
    }

    public void switchDivisa(View view){

        Intent intent = new Intent(this, MainActivity.class);
//        String message = eur_input.getText().toString();
//
//        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
        Log.d(LOG_TAG, "Cambio de Convertidor a EUROS");

    }
}