package Tarea1_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cadena {
    public static void main (String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();  // Leer una línea de la entrada
        try {

            // Procesar y mostrar la entrada
            System.out.println("Entrada recibida: " + input);
        }catch (Exception e) { e.printStackTrace();
        }

    }
}

