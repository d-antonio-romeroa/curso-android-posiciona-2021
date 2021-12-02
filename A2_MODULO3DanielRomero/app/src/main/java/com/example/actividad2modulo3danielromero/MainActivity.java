package com.example.actividad2modulo3danielromero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    TextView total;
    Button sum, mult, div, resta;
    EditText n1, n2;
    float n1_float, n2_float, total_float = 0;
    private static final String TAG = "Calculadora Simple";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sum = (Button) findViewById(R.id.sum);
        mult = (Button) findViewById(R.id.mult);
        resta = (Button) findViewById(R.id.resta);
        div = (Button) findViewById(R.id.div);

        n1 = (EditText) findViewById(R.id.n1);
        n2 = (EditText) findViewById(R.id.n2);
        total = (TextView) findViewById(R.id.total);

        Log.d(TAG, " INICIO APP CALCULADORA");
//        System.out.println("----------------------------------------------------");


        sum.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG, " INICIO SUMA");

                System.out.println(n1.getText());
                if (!n1.getText().equals("")) {
                    n1_float = Float.parseFloat(n1.getText()+"");
                } else {
                    n1_float = 0;
                }
                if (!n2.getText().equals("")) {
                    n2_float = Float.parseFloat(n2.getText()+"");
                } else {
                    n2_float = 0;
                }

                total_float = n1_float + n2_float;

                total.setText(total_float+"");
                Log.d(TAG, " FIN SUMA, TOTAL: "+String.valueOf(total_float)+"");

            }
        });

        resta.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG, " INICIO RESTA");
                if (!n1.getText().equals("")) {
                    n1_float = Float.parseFloat(n1.getText()+"");
                } else {
                    n1_float = 0;
                }
                if (!n2.getText().equals("")) {
                    n2_float = Float.parseFloat(n2.getText()+"");
                } else {
                    n2_float = 0;
                }

                total_float = n1_float - n2_float;

                total.setText(total_float+"");
                Log.d(TAG, " FIN RESTA, TOTAL: "+String.valueOf(total_float)+"");

            }
        });

        mult.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG, " INICIO MULTIPLICACION");
                if (!n1.getText().equals("")) {
                    n1_float = Float.parseFloat(n1.getText()+"");
                } else {
                    n1_float = 0;
                }
                if (!n2.getText().equals("")) {
                    n2_float = Float.parseFloat(n2.getText()+"");
                } else {
                    n2_float = 0;
                }

                total_float = n1_float * n2_float;

                total.setText(total_float+"");
                Log.d(TAG, " FIN MULTIPLICACION, TOTAL: "+String.valueOf(total_float)+"");

            }
        });

        div.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG, " INICIO DIVISION");
                if (!n1.getText().equals("")) {
                    n1_float = Float.parseFloat(n1.getText()+"");
                } else {
                    n1_float = 0;
                }
                if (!n2.getText().equals("")) {
                    n2_float = Float.parseFloat(n2.getText()+"");
                } else {
                    n2_float = 1;
                }

                total_float = n1_float/n2_float;

                total.setText(total_float+"");
                Log.d(TAG, " FIN DIVISION, TOTAL: "+String.valueOf(total_float)+"");

            }
        });
    }
}