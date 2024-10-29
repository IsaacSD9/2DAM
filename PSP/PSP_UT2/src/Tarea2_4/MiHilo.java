package Tarea2_4;

public class MiHilo extends Thread {
    private SolicitaSuspender suspender = new SolicitaSuspender(); // Controlador de suspensión
    private int contador = 0; // Variable contador que se inicia en 0

    public void Suspende() {
        suspender.set(true); // Suspende el hilo
    }

    public void Reanuda() {
        suspender.set(false); // Reanuda el hilo
    }

    public int getContador() {
        return contador; // Devuelve el valor actual del contador
    }

    // Metodo run() que ejecuta el hilo
    public void run() {
        try {
            while (contador < 10) { // Control de fin del hilo
                contador++; // Incrementa el contador
                System.out.println("Contador: " + contador); // Visualiza el valor del contador
                Thread.sleep(1000); // Espera para que podamos ver los números
                suspender.esperandoParaReanudar(); // Suspende el hilo si es necesario
            }
            System.out.println("Fin del bucle en el hilo.");
        } catch (InterruptedException e) {
            System.out.println("Hilo interrumpido.");
        }
    }
}