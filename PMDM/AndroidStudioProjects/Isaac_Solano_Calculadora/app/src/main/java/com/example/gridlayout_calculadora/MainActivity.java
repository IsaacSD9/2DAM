package com.example.gridlayout_calculadora;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


    }

    Button boton1 = findViewById(R.id.uno);
    Button boton2 = findViewById(R.id.dos);
    Button boton3 = findViewById(R.id.tres);
    Button boton4 = findViewById(R.id.cuatro);
    Button boton5 = findViewById(R.id.cinco);
    Button boton6 = findViewById(R.id.seis);
    Button boton7 = findViewById(R.id.siete);
    Button boton8 = findViewById(R.id.ocho);
    Button boton9 = findViewById(R.id.nueve);
    Button boton0 = findViewById(R.id.cero);

}


