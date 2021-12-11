package com.example.salavatcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class SettingsActivity extends AppCompatActivity {

    String[] languages = {"Русский", "English", "Татарча", "Башкортса", "Ўзбекча", "тоҷикӣ"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Spinner spinner = findViewById(R.id.spinner);
        // Создаем адаптер ArrayAdapter с помощью массива строк и стандартной разметки элемета spinner
        ArrayAdapter<String> adapter1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, languages);
        // Определяем разметку для использования при выборе элемента
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        spinner.setAdapter(adapter1);

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


}