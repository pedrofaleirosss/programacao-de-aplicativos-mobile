package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Spinner instCmbNiveis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        instCmbNiveis = findViewById(R.id.cmbNiveis);

        String strNiveis[] = {"", "Estagiário", "Pleno", "Sênior"};
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, strNiveis);
        instCmbNiveis.setAdapter(arrayAdapter);

        
    }
}