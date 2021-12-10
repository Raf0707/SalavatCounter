package com.example.salavatcounter;

import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.*;

import android.animation.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.graphics.drawable.shapes.*;
import android.os.*;
import android.text.*;
import android.view.*;
import android.view.animation.*;
import android.widget.*;


public class MainActivity extends AppCompatActivity {
    public int myCounter = 0;
    Button button;
    Button Zero;
    Button Minus;
    Button Ok;
    TextView textView;
    EditText text1;
    int maxvalue;
    int tsel;
    int currentPage;



    String[] salavats = {"Йаумитдин", "Аль-Фатиха", "ДжазаЛлах", "Шафа'ат Всех пророков"};

    String[] texts = {"", "", ""};

    int[] salavaty = {R.string.salavat, R.string.salavatFatiha};

    private static final TimeInterpolator GAUGE_ANIMATION_INTERPOLATOR = new DecelerateInterpolator(2);
    private static final long GAUGE_ANIMATION_DURATION = 50000;
    private ProgressBar mProgressBar;




    @RequiresApi(api = Build.VERSION_CODES.M)

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

        mProgressBar.getProgressDrawable().setColorFilter(
                Color.rgb(18, 112, 90), android.graphics.PorterDuff.Mode.SRC_IN);

        text1.getBackground().setColorFilter(Color.rgb(18, 112, 90), PorterDuff.Mode.SRC_ATOP);


        Spinner spinner = findViewById(R.id.spinner);
        // Создаем адаптер ArrayAdapter с помощью массива строк и стандартной разметки элемета spinner
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, salavats);
        // Определяем разметку для использования при выборе элемента
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        spinner.setAdapter(adapter);

        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // Получаем выбранный объект
                String item = (String)parent.getItemAtPosition(position);
                //selection.setText(item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }


        };
        spinner.setOnItemSelectedListener(itemSelectedListener);

    }



    class Navigation implements View.OnClickListener {
        @Override
        public void onClick(View v) {


        }
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