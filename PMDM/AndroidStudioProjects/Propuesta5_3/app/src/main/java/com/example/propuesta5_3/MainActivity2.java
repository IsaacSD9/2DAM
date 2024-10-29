package com.example.propuesta5_3;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    private TextView miTexto;
    private Button boton1, boton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        miTexto = findViewById(R.id.miTexto);
        boton1 = findViewById(R.id.boton1);
        boton2 = findViewById(R.id.boton2);

        // Asociar el botón 1 con el escuchador personalizado que cambia a rojo
        boton1.setOnClickListener(new MiEscuchador(miTexto, "Botón 1 pulsado", Color.RED));

        // Asociar el botón 2 con el escuchador personalizado que cambia a verde
        boton2.setOnClickListener(new MiEscuchador(miTexto, "Botón 2 pulsado", Color.GREEN));
    }

    // Clase interna que implementa el escuchador
    private static class MiEscuchador implements View.OnClickListener {
        private final TextView miTexto;
        private final String mensaje;
        private final int color;

        public MiEscuchador(TextView texto, String mensaje, int color) {
            this.miTexto = texto;
            this.mensaje = mensaje;
            this.color = color;
        }

        @Override
        public void onClick(View v) {
            miTexto.setText(mensaje);
            miTexto.setTextColor(color);
        }
    }
}