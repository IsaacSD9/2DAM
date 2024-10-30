package com.example.actividadpractica3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText textoLeido1 = findViewById(R.id.editText1);
        EditText textoLeido2 = findViewById(R.id.editText2);
        Button button1 = findViewById(R.id.miBoton);
        TextView texto = findViewById(R.id.miTexto);

        CheckBox checkBox1 = findViewById(R.id.checkBox1); // Checkbox para suma
        CheckBox checkBox2 = findViewById(R.id.checkBox2); // Checkbox para resta

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int numero1 = Integer.parseInt(textoLeido1.getText().toString());
                    int numero2 = Integer.parseInt(textoLeido2.getText().toString());
                    String resultado = "";

                    if (checkBox1.isChecked()) {
                        int suma = numero1 + numero2;
                        resultado += "Suma: " + suma + "\n";
                    }

                    if (checkBox2.isChecked()) {
                        int resta = numero1 - numero2;
                        resultado += "Resta: " + resta + "\n";
                    }

                    if (!checkBox1.isChecked() && !checkBox2.isChecked()) {
                        resultado = "Selecciona al menos una operación.";
                    }

                    texto.setText(resultado);

                } catch (NumberFormatException e) {
                    texto.setText("Error: Ingresa números válidos.");
                }
            }
        });
    }
}
