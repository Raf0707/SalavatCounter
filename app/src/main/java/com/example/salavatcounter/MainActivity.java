package com.example.salavatcounter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.*;

import android.animation.*;
import android.content.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.graphics.drawable.shapes.*;
import android.text.*;
import android.view.*;
import android.view.animation.*;
import android.widget.*;
import android.os.Bundle;




public class MainActivity extends AppCompatActivity {
    private int myCounter = 0;
    Button button;
    Button Zero;
    Button Minus;
    Button Ok;
    TextView textView;
    EditText text1;
    int maxvalue;
    int tsel;




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
        text1 = findViewById(R.id.Tsel);
        Ok = findViewById(R.id.ok);



        button.setOnClickListener(new Counter());
        Zero.setOnClickListener(new Zerooo());
        Minus.setOnClickListener(new Minuss());
        Ok.setOnClickListener(new Ok());


    }

    class Counter implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            myCounter++;
            textView.setText(Integer.toString(myCounter));

            ObjectAnimator animator = ObjectAnimator.ofInt(mProgressBar, "progress", myCounter, myCounter);
            animator.setInterpolator(GAUGE_ANIMATION_INTERPOLATOR);
            animator.setDuration(GAUGE_ANIMATION_DURATION);
            animator.start();



            if (text1.length() != 0) {
                tsel = Integer.parseInt(text1.getText().toString());
                if (myCounter == tsel) {
                    Toast toast = Toast.makeText(getApplicationContext(), R.string.CompleteTsel, Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();

                }
            } else {
                tsel = 100;
                if (myCounter == tsel) {
                    Toast toast = Toast.makeText(getApplicationContext(), R.string.CompleteTsel, Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();

                }
            }

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

            ObjectAnimator animator = ObjectAnimator.ofInt(mProgressBar, "progress", myCounter, myCounter);
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

            ObjectAnimator animator = ObjectAnimator.ofInt(mProgressBar, "progress", myCounter, myCounter);
            animator.setInterpolator(GAUGE_ANIMATION_INTERPOLATOR);
            animator.setDuration(GAUGE_ANIMATION_DURATION);
            animator.start();
        }
    }


    class Ok implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            if (text1.length() == 0) {
                Toast toast = Toast.makeText(getApplicationContext(), R.string.vvediteTsel, Toast.LENGTH_SHORT);
                toast.show();
            } else if (text1.length() > 0) {
                String a = text1.getText().toString();
                int b = new Integer(a).intValue();
                if (b > 0) {
                    Toast toast = Toast.makeText(getApplicationContext(), R.string.textToast, Toast.LENGTH_SHORT);
                    toast.show();
                    maxvalue = b;
                    mProgressBar.setMax(maxvalue);
                } else if (b == 0) {
                    Toast toast = Toast.makeText(getApplicationContext(), R.string.vvediteTsel, Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        }

    }

}