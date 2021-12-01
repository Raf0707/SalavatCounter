package com.example.salavatcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.*;
import android.view.*;
import android.view.animation.*;
import android.widget.*;
import android.os.Bundle;

//import java.awt.*;

public class MainActivity extends AppCompatActivity {
    private int myCounter = 0;
    Button button;
    Button Zero;
    Button Minus;
    TextView textView;
    int maxvalue;


    private static final TimeInterpolator GAUGE_ANIMATION_INTERPOLATOR = new DecelerateInterpolator(2);
    private static final long GAUGE_ANIMATION_DURATION = 50000;
    private ProgressBar mProgressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        Zero = findViewById(R.id.Zzero);
        Minus = findViewById(R.id.minus);
        textView = findViewById(R.id.count);
        mProgressBar = findViewById(R.id.mainProgressBar);
        mProgressBar.setVisibility(ProgressBar.VISIBLE);

        class Counter implements View.OnClickListener {
            @Override
            public void onClick(View v) {
                myCounter++;
                textView.setText(Integer.toString(myCounter));

                ObjectAnimator animator = ObjectAnimator.ofInt(mProgressBar, "progress", myCounter - 1, myCounter);
                animator.setInterpolator(GAUGE_ANIMATION_INTERPOLATOR);
                animator.setDuration(GAUGE_ANIMATION_DURATION);
                animator.start();
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

                ObjectAnimator animator = ObjectAnimator.ofInt(mProgressBar, "progress", myCounter - 1, myCounter);
                animator.setInterpolator(GAUGE_ANIMATION_INTERPOLATOR);
                animator.setDuration(GAUGE_ANIMATION_DURATION);
                animator.start();
            }
        }

        class Zerooo implements View.OnClickListener {
            @Override
            public void onClick(View v) {
                myCounter = 0;
                textView.setText(Integer.toString(myCounter));

                ObjectAnimator animator = ObjectAnimator.ofInt(mProgressBar, "progress", myCounter - 1, myCounter);
                animator.setInterpolator(GAUGE_ANIMATION_INTERPOLATOR);
                animator.setDuration(GAUGE_ANIMATION_DURATION);
                animator.start();
            }
        }

        button.setOnClickListener(new Counter());
        Zero.setOnClickListener(new Zerooo());
        Minus.setOnClickListener(new Minuss());



    }



}