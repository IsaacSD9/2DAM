package Tarea1_3;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class EjecutarSuma {

    public static void main(String[] args) {

        // Este programa ejecuta la clase "Suma" del paquete "Tarea1_3" usando ProcessBuilder, especificando el directorio donde se encuentra el archivo .class.
// Envía dos números como entrada al programa "Suma" a través de su flujo de salida (OutputStream).
// Luego, lee y muestra la salida generada por el proceso.
// Al finalizar, imprime el código de salida del proceso, indicando si terminó correctamente o con errores.


        try {
/*
        File directorio = new File("/home/usuario/IdeaProjects/UT1_PSP/out/production/UT1_PSP");
*/
        // La ruta que tengo que poner es dónde se encuentra mi archivo .class
            File directorio = new File("C:\\Users\\Isaac SD\\Desktop\\2ºDAM\\PSP\\UT1_PSP\\out\\production\\UT1_PSP");


/*
            ProcessBuilder pb = new ProcessBuilder("/home/usuario/.jdks/openjdk-23/bin/java", "Tarea1_3.Suma");
*/
            ProcessBuilder pb = new ProcessBuilder("java",  "Tarea1_3.Suma");

            pb.directory(directorio);
        Process p = pb.start();
            try {
                OutputStream out = p.getOutputStream();
                out.write("10\n".getBytes());
                out.write("35\n".getBytes());

                out.flush();

            }catch (Exception e){
                e.printStackTrace();
            }

            try {
                InputStream is = p.getInputStream();
                int e;
                while ((e = is.read()) != -1)
                    System.out.print((char) e);
                is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        int exitCode = p.waitFor();
        System.out.println("El programa terminó con código: " + exitCode);

    } catch (IOException e) {
        System.out.println("Error al intentar ejecutar el programa: " + e.getMessage());
    } catch (InterruptedException e) {
        System.out.println("El proceso fue interrumpido: " + e.getMessage());
    }

    }
}


