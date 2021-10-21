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
        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("coloqueSuCodigoAqui", "se ha pulsado el boton FAB");
            }
        });


        TextView mShowCount = (TextView) findViewById(R.id.show_count);
    }

    public void showToastMsg(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message,
                Toast.LENGTH_SHORT);
        toast.show();
    }

    public void countUp(View view) {
        ++mCount;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
    }



}