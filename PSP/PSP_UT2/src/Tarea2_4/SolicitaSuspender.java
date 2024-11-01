package Tarea2_4;

public class SolicitaSuspender {
    private boolean enEspera; // Indicador para pausar el hilo

    public synchronized void actualizarEstado(boolean estado) {
        enEspera = estado;
        notifyAll(); // Notifica a los hilos en espera cuando el estado cambia
    }

    public synchronized void verificarReanudacion() throws InterruptedException {
        while (enEspera) {
            wait(); // Mantiene el hilo en espera si el estado es true
        }
    }
}