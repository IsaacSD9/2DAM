package Ejercicio_1;


public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            MiHilo hilo = new MiHilo( "Hola mundo "+ (i+1));
        hilo.start();

        }
    }
}
