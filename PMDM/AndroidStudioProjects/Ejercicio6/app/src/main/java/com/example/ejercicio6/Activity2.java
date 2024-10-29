package com.example.ejercicio6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        String nombre = getIntent().getStringExtra("nombre");
        double num = getIntent().getDoubleExtra("numero", 0.0);
        Toast toast = Toast.makeText(this, "Nombre = " + nombre + "\n Edad = " + num, Toast.LENGTH_LONG);
        toast.show();
    }


}