package com.example.salavatcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.*;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    private int myCounter = 0;
    Button button;
    Button Zero;
    Button Minus;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        Zero = findViewById(R.id.Zzero);
        Minus = findViewById(R.id.minus);
        textView = (TextView) findViewById(R.id.count);


        class Counter implements View.OnClickListener {
            @Override
            public void onClick(View v) {
                myCounter++;
                textView.setText(Integer.toString(myCounter));
            }
        }

        class Minuss implements View.OnClickListener {
            @Override
            public void onClick(View v) {
                myCounter--;
                if (myCounter < 0) {
                    myCounter = 0;
                }
                textView.setText(Integer.toString(myCounter));
            }
        }

        class Zerooo implements View.OnClickListener {
            @Override
            public void onClick(View v) {
                myCounter = 0;
                textView.setText(Integer.toString(myCounter));
            }
        }

        button.setOnClickListener(new Counter());
        Zero.setOnClickListener(new Zerooo());
        Minus.setOnClickListener(new Minuss());


    }


}