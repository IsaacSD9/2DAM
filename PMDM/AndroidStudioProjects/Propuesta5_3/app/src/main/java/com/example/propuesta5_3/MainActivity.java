package com.example.propuesta5_3;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView miTexto;
    private Button miBoton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miTexto = findViewById(R.id.miTexto);
        miBoton = findViewById(R.id.miBoton);
        miBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                miTexto.setText("Botón pulsado");
                miTexto.setTextColor(Color.RED);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Iniciar la segunda actividad cuando la primera se destruya
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(intent);
    }
}