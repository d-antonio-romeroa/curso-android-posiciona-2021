package com.example.a6_modulo3_danielromero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    ImageButton product_1, product_2, product_3;
    private String mOrderMessage;
    FloatingActionButton fab;
    Integer mCount = 0;
    TextView mShowCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        product_1 = (ImageButton) findViewById(R.id.p1);
        product_2 = (ImageButton) findViewById(R.id.p2);
        product_3 = (ImageButton) findViewById(R.id.p3);

//        product_1.setOnClickListener(new View.OnClickListener() {
//                 @Override
//                 public void onClick(View v) {
//
//                 }
//             }
//
//        );
        fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countUp(view);
                Log.d("coloqueSuCodigoAqui", "se ha pulsado el boton FAB");
            }
        });

        product_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToastMsg(product_1.getContentDescription().toString());
                Log.d("coloqueSuCodigoAqui", "se ha pulsado el boton ICECREAMSANDWICH");
            }
        });

        product_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToastMsg(product_2.getContentDescription().toString());
                Log.d("coloqueSuCodigoAqui", "se ha pulsado el boton DONUTS");
            }
        });

        product_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToastMsg(product_3.getContentDescription().toString());
                Log.d("coloqueSuCodigoAqui", "se ha pulsado el boton FROYO");
            }
        });


        mShowCount = (TextView) findViewById(R.id.show_count);
    }

    public void showToastMsg(String msg) {
        Toast toast = Toast.makeText(this, msg,
                Toast.LENGTH_SHORT);
        toast.show();
    }

    public void countUp(View view) {
        ++mCount;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
    }



}