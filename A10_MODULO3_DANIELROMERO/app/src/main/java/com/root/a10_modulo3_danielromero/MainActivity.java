package com.root.a10_modulo3_danielromero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView leftDice = findViewById(R.id.imagenDadoIzq);
        final ImageView rightDice = findViewById(R.id.imagenDadoDer);

        Button myButton = findViewById(R.id.lanzar);

        final int[] diceArray = new int[] {
                R.drawable.dado1,
                R.drawable.dado2,
                R.drawable.dado3,
                R.drawable.dado4,
                R.drawable.dado5,
                R.drawable.dado6
        };

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random randomNumberGenerator = new Random();
                int number = randomNumberGenerator.nextInt(6);
                Log.d("Dados", "El numero de la izquierda es " + number);

                int imageResourceId = diceArray[number];
                leftDice.setImageResource(imageResourceId);

                number = randomNumberGenerator.nextInt(6);
                Log.d("Dados", "El numero de la derecha es " + number);
                imageResourceId = diceArray[number];
                rightDice.setImageResource(imageResourceId);
            }
        });


    }
}