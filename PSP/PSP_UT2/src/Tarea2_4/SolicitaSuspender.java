package Tarea2_4;

public class SolicitaSuspender {
    private boolean suspender; // Bandera para suspender el hilo

    public synchronized void set(boolean b) {
        suspender = b;
        notifyAll(); // Despierta a los hilos en espera cuando la bandera cambia
    }

    public synchronized void esperandoParaReanudar() throws InterruptedException {
        while (suspender) {
            wait(); // Suspende el hilo mientras la bandera sea true
        }
    }
}