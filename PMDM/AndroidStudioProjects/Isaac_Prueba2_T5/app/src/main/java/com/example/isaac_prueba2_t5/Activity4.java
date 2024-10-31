package com.example.isaac_prueba2_t5;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity4 extends AppCompatActivity {
    private AutoCompleteTextView autoCompleteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla4);

        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
        String[] versiones = {
                "APPLE PIE", "BANANA BREAD", "CUPCAKE", "DONUT",
                "ECLAIR", "FROYO", "GINGERBREAD", "HONEYCOMB",
                "ICE CREAM SANDWICH", "JELLY BEAN", "KITKAT",
                "LOLLIPOP", "MARSHMALLOW", "NOUGAT", "OREO",
                "PIE", "ANDROID 10"
        };
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, versiones);
        autoCompleteTextView.setAdapter(adaptador);
    }
}

