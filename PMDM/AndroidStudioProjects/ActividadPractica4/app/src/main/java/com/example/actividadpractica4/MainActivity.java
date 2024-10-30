package com.example.actividadpractica4;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText textoLeido1;
    private EditText textoLeido2;
    private TextView texto;
    private CheckBox checkBox1; // Checkbox para suma
    private CheckBox checkBox2; // Checkbox para resta

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        textoLeido1 = findViewById(R.id.editText1);
        textoLeido2 = findViewById(R.id.editText2);
        texto = findViewById(R.id.miTexto);
        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);

        // Listener para el checkbox de suma
        checkBox1.setOnCheckedChangeListener((buttonView, isChecked) -> calcularResultados());

        // Listener para el checkbox de resta
        checkBox2.setOnCheckedChangeListener((buttonView, isChecked) -> calcularResultados());
    }

    private void calcularResultados() {
        String resultado = "";

        try {
            int numero1 = Integer.parseInt(textoLeido1.getText().toString());
            int numero2 = Integer.parseInt(textoLeido2.getText().toString());

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
}
