package Ejercicio_2;

public class Main {
    public static void main(String[] args) {


        for (int i = 1; i < 6; i++) {
            Runnable tarea0 = new MiHilo( " hilo "+ i+" ");
            Thread hilo0 = new Thread(tarea0);
            hilo0.start();
        }


    }
    }
