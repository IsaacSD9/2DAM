package com.example.actividad4_1;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Iniciar la segunda actividad al destruir la actual
        Intent main2 = new Intent(this, MainActivity2.class);
        startActivity(main2);
    }
}