package com.example.actividad2modulo3danielromero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView total;
    Button sum, mult, div, resta;
    EditText n1, n2;
    float n1_float, n2_float, total_float = 0;

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


        System.out.println("----------------------------------------------------");


        sum.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
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

                Log.d("MainActivity", "Calculadora - Operacion Suma");

                total.setText(total_float+"");

            }
        });

        resta.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
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
                Log.d("MainActivity", "Calculadora - Operacion Resta");

                total.setText(total_float+"");

            }
        });

        mult.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
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
                Log.d("MainActivity", "Calculadora - Operacion Multiplicación");

                total.setText(total_float+"");

            }
        });

        div.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
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
                Log.d("MainActivity", "Calculadora - Operacion División");

                total.setText(total_float+"");

            }
        });
    }
}