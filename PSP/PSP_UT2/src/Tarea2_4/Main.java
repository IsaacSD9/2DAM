package Tarea2_4;

public class Main {
    public static void main(String[] args) {
        MiHilo hilo = new MiHilo(); // Crea una instancia de MyHilo
        hilo.start(); // Inicia el hilo

        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String entrada;

        do {
            System.out.println("Introduce una cadena (* para finalizar, S para suspender, R para reanudar):");
            entrada = scanner.nextLine(); // Lee la cadena introducida por el usuario

            if (entrada.equals("S")) {
                hilo.Suspende(); // Suspende el hilo
                System.out.println("Hilo suspendido.");
            } else if (entrada.equals("R")) {
                hilo.Reanuda(); // Reanuda el hilo
                System.out.println("Hilo reanudado.");
            }

        } while (!entrada.equals("*")); // El bucle se repite hasta que se introduce *

        if (entrada.equals("*")) { // Si se ha seleccionado terminar se finaliza la ejecución del hilo
            hilo.stop();
        }
        System.out.println("Valor final del contador: " + hilo.getContador());
        System.out.println("Fin del programa.");
    }
}
