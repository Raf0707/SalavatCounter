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
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        Zero = (Button) findViewById(R.id.Zzero);
        textView = (TextView) findViewById(R.id.count);


        class Counter implements View.OnClickListener {
            @Override
            public void onClick(View v) {
                myCounter++;
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


    }


}