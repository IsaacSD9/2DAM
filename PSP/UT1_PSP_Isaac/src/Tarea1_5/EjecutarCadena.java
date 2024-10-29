package Tarea1_5;

import java.io.*;

public class EjecutarCadena {

    public static void main(String[] args) {

        // Este programa ejecuta la clase "Cadena" del paquete "Tarea1_5" utilizando ProcessBuilder, estableciendo el directorio donde se encuentra el archivo .class.
// Redirige la entrada desde un archivo "entrada2.txt" y muestra la salida estándar en la consola (INHERIT).
// Luego, el programa lee de nuevo los datos del archivo "entrada2.txt" y los escribe en un archivo de salida "salida2.txt".
// Finalmente, imprime el código de salida del proceso, indicando si terminó correctamente o con errores.


        try {
/*
                    File directorio = new File("/home/usuario/IdeaProjects/UT1_PSP/out/production/UT1_PSP");
*/
            File directorio = new File("C:\\Users\\Isaac SD\\Desktop\\2ºDAM\\PSP\\UT1_PSP\\out\\production\\UT1_PSP");
            ProcessBuilder pb = new ProcessBuilder("java", "Tarea1_5.Cadena");
/*
            ProcessBuilder pb = new ProcessBuilder("/home/usuario/.jdks/openjdk-23/bin/java", "Tarea1_5.Cadena");
*/

            pb.directory(directorio);

            // Redirigir la entrada desde un archivo
            File inputFile = new File("src/Tarea1_5/entrada2.txt");
            pb.redirectInput(ProcessBuilder.Redirect.from(inputFile));

            pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);


            // Iniciar el proceso
            Process p = pb.start();

            // Esperar a que el proceso termine
            int exitCode = p.waitFor();
            System.out.println("El programa terminó con código: " + exitCode);

        } catch (IOException e) {
            System.out.println("Error al intentar ejecutar el programa: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("El proceso fue interrumpido: " + e.getMessage());
        }

        //Leemos de un fichero de entrada y lo que hemos leído lo almacenamos en un nuevo fichero de salida
        try(BufferedReader br= new BufferedReader(new FileReader("src/Tarea1_5/entrada2.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/Tarea1_5/salida2.txt"))) {
            String texto = br.readLine();  // Leer una línea de la entrada
            bw.write("Entrada recibida: " + texto);  // Escribir en el archivo de salida

        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
