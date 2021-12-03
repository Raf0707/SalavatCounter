package com.example.salavatcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.*;
import android.content.*;
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
    Object toast;



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

    class Tsel implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            text1.setText(Integer.toString(maxvalue));

        }
    }

    class Maxvalue implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            mProgressBar.setMax(maxvalue);
        }

    }

    class Ok implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            //text1.setText(maxvalue);
            //maxvalue = Integer.parseInt(String.valueOf(text1));
            //mProgressBar.setMax(maxvalue);
            if (text1.length() > 0) {
                Toast toast = Toast.makeText(getApplicationContext(), R.string.textToast, Toast.LENGTH_SHORT);
                toast.show();
            } else if (text1.length() == 0) {
                Toast toast = Toast.makeText(getApplicationContext(), R.string.vvediteTsel, Toast.LENGTH_SHORT);
                toast.show();
            }
        }

    }
}