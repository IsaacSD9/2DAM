package com.example.ejemplo2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Actividad1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Ajuste de los insets de la ventana
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Log.i("EjemploActividad1", "onCreate");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("EjemploActividad1", "onDestroy");

        // Iniciar la segunda actividad al destruir la actual
        Intent ejemplo = new Intent(this, Actividad2.class);
        startActivity(ejemplo);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("EjemploActividad1", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("EjemploActividad1", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("EjemploActividad1", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("EjemploActividad1", "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("EjemploActividad1", "onRestart");
    }


}
