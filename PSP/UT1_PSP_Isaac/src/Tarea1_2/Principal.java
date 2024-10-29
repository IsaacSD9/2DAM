package Tarea1_2;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Principal {
    public static void main(String[] args) throws IOException {
        // Este programa utiliza ProcessBuilder para intentar ejecutar una clase Java llamada "NoExiste" del paquete "Tarea1_2".
// Define el directorio donde se encuentra el archivo .class y lo ejecuta.
// Captura la salida estándar y de error del proceso y las imprime.
// Al no existir la clase "NoExiste", se mostrará un error que indica que la clase no pudo ser encontrada o cargada.



/*
        File directorio = new File("/home/usuario/IdeaProjects/UT1_PSP/out/production/UT1_PSP");
*/
        // La ruta que tengo que poner es dónde se encuentra mi archivo .class
        File directorio = new File("C:\\Users\\Isaac SD\\Desktop\\2ºDAM\\PSP\\UT1_PSP\\out\\production\\UT1_PSP");


        ProcessBuilder pb = new ProcessBuilder("java", "Tarea1_2.NoExiste");
        pb.directory(directorio);
        System.out.printf("Directorio de trabajo: %s%n", pb.directory());

        Process p = pb.start();

        try {
            InputStream is = p.getInputStream();
            int e;
            while ((e = is.read()) != -1)
                System.out.print((char) e);
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            InputStream es = p.getErrorStream();
            int e;
            // Este bucle lee e imprime los errores generados por el proceso.
            // Si el programa "NoExiste" del paquete "Tarea1_2" no existe, se lanzará el siguiente error:
            // "Error: Could not find or load main class "NoExiste"
            while ((e = es.read()) != -1) {
                System.err.print((char) e);
            }
            es.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
