package com.example.wordle;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private final String PALABRA = "dubai"; // La palabra a adivinar
    private int filaActual = 1; // Variable para saber el número de fila actual de intento

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configuración de la primera fila de EditText y TextView para el mensaje
        configurarFila(1); // Llama a configurarFila para preparar la primera fila de intento
    }

    // Método para configurar cada fila de EditText
    private void configurarFila(int numeroFila) {
        // Obtener los IDs de los EditText de la fila actual usando el número de fila
        int edt1Id = getResources().getIdentifier("edt_" + numeroFila + "1", "id", getPackageName());
        int edt2Id = getResources().getIdentifier("edt_" + numeroFila + "2", "id", getPackageName());
        int edt3Id = getResources().getIdentifier("edt_" + numeroFila + "3", "id", getPackageName());
        int edt4Id = getResources().getIdentifier("edt_" + numeroFila + "4", "id", getPackageName());
        int edt5Id = getResources().getIdentifier("edt_" + numeroFila + "5", "id", getPackageName());

        // Asignar cada EditText para la fila de intento
        EditText edt1 = findViewById(edt1Id);
        EditText edt2 = findViewById(edt2Id);
        EditText edt3 = findViewById(edt3Id);
        EditText edt4 = findViewById(edt4Id);
        EditText edt5 = findViewById(edt5Id);

        // Referencia del TextView donde se mostrará el mensaje de éxito o error
        TextView mensaje = findViewById(R.id.textview);

        // Configurar un listener en el último EditText de la fila actual (edt5)
        edt5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                // Cuando se ha ingresado un carácter en el último EditText
                if (s.length() == 1) {
                    // Validar la fila completa cuando el último EditText recibe entrada
                    validarFila(edt1, edt2, edt3, edt4, edt5, mensaje);
                }
            }
        });
    }

    // Método para validar la fila de EditText y verificar la palabra
    private void validarFila(EditText edt1, EditText edt2, EditText edt3, EditText edt4, EditText edt5, TextView mensaje) {
        // Obtener el texto ingresado en cada EditText de la fila
        String texto1 = edt1.getText().toString();
        String texto2 = edt2.getText().toString();
        String texto3 = edt3.getText().toString();
        String texto4 = edt4.getText().toString();
        String texto5 = edt5.getText().toString();

        // Cambiar el color de fondo de cada EditText según la coincidencia de letras con PALABRA
        cambiarColor(edt1, texto1, PALABRA.charAt(0));
        cambiarColor(edt2, texto2, PALABRA.charAt(1));
        cambiarColor(edt3, texto3, PALABRA.charAt(2));
        cambiarColor(edt4, texto4, PALABRA.charAt(3));
        cambiarColor(edt5, texto5, PALABRA.charAt(4));

        // Verificar si la palabra ingresada es completamente correcta
        if (texto1.equals(String.valueOf(PALABRA.charAt(0))) &&
                texto2.equals(String.valueOf(PALABRA.charAt(1))) &&
                texto3.equals(String.valueOf(PALABRA.charAt(2))) &&
                texto4.equals(String.valueOf(PALABRA.charAt(3))) &&
                texto5.equals(String.valueOf(PALABRA.charAt(4)))) {

            // Mostrar mensaje de éxito y desactivar la fila si la palabra es correcta
            mensaje.setText("¡Felicidades, adivinaste la palabra!");
            mensaje.setVisibility(View.VISIBLE);
            Toast.makeText(this, "¡Correcto! Has adivinado la palabra.", Toast.LENGTH_SHORT).show();
            desactivarJuego(edt1, edt2, edt3, edt4, edt5);
        } else {
            // Incrementar el número de fila e intentar en la siguiente fila si no es correcta
            filaActual++;
            if (filaActual <= 6) { // Limitar el número de intentos a 6 filas
                configurarFila(filaActual); // Configurar la siguiente fila para un nuevo intento
            } else {
                // Mostrar mensaje de error si se han agotado los intentos
                mensaje.setText("Lo siento, no has adivinado la palabra.");
                mensaje.setVisibility(View.VISIBLE);
            }
        }
    }

    // Método para cambiar el color de fondo de un EditText según si la letra es correcta o está en la palabra
    private void cambiarColor(EditText edt, String letraUsuario, char letraCorrecta) {
        if (letraUsuario.equals(String.valueOf(letraCorrecta))) {
            // Verde si la letra es correcta y está en la posición correcta
            edt.setBackgroundColor(Color.parseColor("#33cc33"));
        } else if (PALABRA.contains(letraUsuario)) {
            // Amarillo si la letra está en otra posición
            edt.setBackgroundColor(Color.parseColor("#ffff00"));
        } else {
            // Rojo si la letra no está en la palabra
            edt.setBackgroundColor(Color.parseColor("#ff3333"));
        }
    }

    // Método para desactivar la fila actual de EditText si la palabra es correcta
    private void desactivarJuego(EditText... edts) {
        for (EditText edt : edts) {
            edt.setEnabled(false); // Desactiva cada EditText en la fila actual
        }
    }
}