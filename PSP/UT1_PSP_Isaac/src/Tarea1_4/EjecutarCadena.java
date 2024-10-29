package Tarea1_4;

import java.io.*;

public class EjecutarCadena {

    public static void main(String[] args) {

        // Este programa ejecuta la clase "Cadena" del paquete "Tarea1_4" usando ProcessBuilder, especificando el directorio donde se encuentra el archivo .class.
// Redirige la entrada del programa desde un archivo de texto "entrada1.txt" y la salida estándar hacia un archivo "salida.txt".
// Además, redirige los errores generados por el programa a un archivo "error.txt".
// Finalmente, imprime el código de salida del proceso, indicando si terminó correctamente o con errores.


        try {
            // Ruta del directorio donde se encuentra el archivo .class
/*
                    File directorio = new File("/home/usuario/IdeaProjects/UT1_PSP/out/production/UT1_PSP");
*/

            File directorio = new File("C:\\Users\\Isaac SD\\Desktop\\2ºDAM\\PSP\\UT1_PSP\\out\\production\\UT1_PSP");

            ProcessBuilder pb = new ProcessBuilder("java", "Tarea1_4.Cadena");
/*
            ProcessBuilder pb = new ProcessBuilder("/home/usuario/.jdks/openjdk-23/bin/java", "Tarea1_4.Cadena");
*/

            pb.directory(directorio);

            // Redirigir la entrada desde un archivo de texto
            File entrada = new File("src/Tarea1_4/entrada1.txt");
            pb.redirectInput(entrada);

            // Redirigir la salida a un archivo de texto
            File salida = new File("src/Tarea1_4/salida.txt");
            pb.redirectOutput(salida);

            File salidaError = new File("src/Tarea1_4/error.txt"); /* Archivo de texto que guardará los errores */
            pb.redirectError(salidaError);
            Process p = pb.start();

            // Esperar a que el proceso termine
            int exitCode = p.waitFor();
            System.out.println("El programa terminó con código: " + exitCode);

        } catch (IOException e) {
            System.out.println("Error al intentar ejecutar el programa: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("El proceso fue interrumpido: " + e.getMessage());
        }
    }
}
