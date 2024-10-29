package Tarea1_1;

import java.util.Arrays;
import java.io.*;
public class EjecutarLeerNombre {

    public static void main(String[] args) throws IOException {
        // Este programa utiliza ProcessBuilder para ejecutar una clase Java desde otra clase, especificando un directorio donde se encuentra el archivo .class.
        // Ejecuta la clase "LeerNombre" del paquete "Tarea1_1" pasándole como argumento "Isaac". Captura y muestra la salida generada por el proceso y controla
        // posibles excepciones. También imprime el valor de salida del proceso cuando este finaliza.




/*
        File directorio = new File("/home/usuario/IdeaProjects/UT1_PSP/out/production/UT1_PSP");
*/
        // La ruta que tengo que poner es dónde se encuentra mi archivo .class
        File directorio = new File("C:\\Users\\Isaac SD\\Desktop\\2ºDAM\\PSP\\UT1_PSP\\out\\production\\UT1_PSP");


        /*
        ProcessBuilder pb = new ProcessBuilder("/home/usuario/.jdks/openjdk-23/bin/java", "Tarea1_1.LeerNombre", "Isaac");
*/
        ProcessBuilder pb = new ProcessBuilder("java", "Tarea1_1.LeerNombre", "Isaac");

        pb.directory(directorio);

        Process p = pb.start();
        int exitVal;
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
                exitVal = p.waitFor(); //recoge la salida de System.exit()
                System.out.println("Valor de Salida: " + exitVal);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        }
    }


