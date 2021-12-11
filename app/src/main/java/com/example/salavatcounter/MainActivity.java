package com.example.salavatcounter;

import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.*;
import androidx.core.content.*;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.graphics.drawable.shapes.*;
import android.os.*;
import android.text.*;
import android.view.*;
import android.view.animation.*;
import android.view.inputmethod.*;
import android.widget.*;

import java.lang.reflect.*;
import java.util.concurrent.*;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private int myCounter = 0;
    int maxvalue;
    int tsel;
    int currentPage = 1;
    Button button;
    Button Zero;
    Button Minus;
    Button Ok;
    TextView textView;
    TextView arabic;
    TextView mtranslate;
    ConstraintLayout myLayout;
    EditText text1;
    Handler handler;
    Display display;
    Point size;





    String[] salavats = {"Йаумитдин", "Аль-Фатиха", "ДжазаЛлах", "Шафа'ат Всех пророков", "111", "222", "333", "444", "555", "666", "777", "888", "999", "1111", "2222", "3333", "4444", "5555", "6666", "7777", "8888", "9999"};

    String[] textsArabic = new String[30];
    String[] textsTranslate = new String[30];


    private static final TimeInterpolator GAUGE_ANIMATION_INTERPOLATOR = new DecelerateInterpolator(2);
    private static final long GAUGE_ANIMATION_DURATION = 50000;
    private ProgressBar mProgressBar;




    @RequiresApi(api = Build.VERSION_CODES.M)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new Handler();
        button = findViewById(R.id.button);
        Zero = findViewById(R.id.Zzero);
        Minus = findViewById(R.id.minus);
        textView = findViewById(R.id.count);
        mProgressBar = findViewById(R.id.mainProgressBar);
        mProgressBar.setVisibility(ProgressBar.VISIBLE);
        text1 = findViewById(R.id.Tsel);
        Ok = findViewById(R.id.ok);
        arabic = findViewById(R.id.arabic);
        mtranslate = findViewById(R.id.translate);
        myLayout = findViewById(R.id.myLayout);
        display = getWindowManager().getDefaultDisplay();
        size = new Point();





        button.setOnClickListener(new Counter());
        Zero.setOnClickListener(new Zerooo());
        Minus.setOnClickListener(new Minuss());
        Ok.setOnClickListener(new Ok());

        mProgressBar.getProgressDrawable().setColorFilter(
                Color.rgb(18, 112, 90), android.graphics.PorterDuff.Mode.SRC_IN);

        text1.getBackground().setColorFilter(Color.rgb(18, 112, 90), PorterDuff.Mode.SRC_ATOP);





        //InputMethodManager inputManager = (InputMethodManager) text1.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        //inputManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);

        //display.getSize(size);
        //windowWidth = size.x;
        //windowHeight = size.y;
        text1.requestFocus();


        Spinner spinner = findViewById(R.id.spinner);
        // Создаем адаптер ArrayAdapter с помощью массива строк и стандартной разметки элемета spinner
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, salavats);
        // Определяем разметку для использования при выборе элемента
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        spinner.setAdapter(adapter);


        class SpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {


            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {
                // An item was selected. You can retrieve the selected item using
                // parent.getItemAtPosition(pos)
            }

            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        }
        spinner.setOnItemSelectedListener(this);

        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // Получаем выбранный объект
                // String item = (String)parent.getItemAtPosition(position);
                //selection.setText(item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }


        };
        spinner.setOnItemSelectedListener(itemSelectedListener);

        Thread t = new Thread(new Runnable(){
            public void run(){
                try{
                    TimeUnit.MILLISECONDS.sleep(100);
                    handler.post(r);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        t.start();

        myLayout.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this) {

            @Override
            public void onSwipeRight() {
                currentPage++;
            }

            @Override
            public void onSwipeLeft() {
                currentPage--;
            }
        });
//-------------------ON_CREATE-----------------------------------------------------------------------------------------------------
    }

    public void initArabic() {
        //textsArabic[0] = Integer.toString(R.string.salavat);
        //textsArabic[1] = Integer.toString(R.string.salavatFatiha);
    }

    public void initRussian() {
        //textsTranslate[0] = Integer.toString(R.string.translate);
        //textsTranslate[1] = Integer.toString(R.string.TranslateFatiha);
    }


    Runnable r = new Runnable() {
        @Override
        public void run() {

            //arabic.setText(textsArabic[currentPage]);
            //handler.postDelayed(r, 2000);
        }
    };

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public void onCheckboxClicked(View view) {
        // Получаем флажок
        CheckBox checkBox = (CheckBox) view;
        TextView selection = findViewById(R.id.translation);
        // Получаем, отмечен ли данный флажок
        if(checkBox.isChecked()) {
            // transription.setText() в прокрутку между арабским текстом и переводом
        }
        else {
            // иначе убрать транскрипцию и оставить остальное
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