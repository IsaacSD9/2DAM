package Tarea2_2;


public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Runnable tarea = new MiHilo( "Hola mundo "+ (i+1));
            Thread hilo = new Thread(tarea);
        hilo.start();

        }
    }
}
