package Tarea1_1;
import java.io.IOException;

import java.util.Arrays;
public class LeerNombre {
    public static void main(String[] args) {
        if (args.length <= 0) {

            System.err.println("Se necesita un programa a ejecutar");

            System.exit(-1);

        } else{
            System.out.println("El nombre es: "+ Arrays.toString(args));
            System.exit(1);
        }



    }
}


