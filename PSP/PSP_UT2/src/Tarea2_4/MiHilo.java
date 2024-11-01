package Tarea2_4;

public class MiHilo extends Thread {
    private SolicitaSuspender controladorSuspension = new SolicitaSuspender();
    private int contador = 0;

    public void pausarHilo() {
        controladorSuspension.actualizarEstado(true); // Activa suspensión del hilo
    }

    public void continuarHilo() {
        controladorSuspension.actualizarEstado(false); // Desactiva suspensión del hilo
    }

    public int obtenerValorContador() {
        return contador; // Devuelve el valor actual del contador
    }

    public void detenerHilo() {
        interrupt(); // Detiene el hilo
    }

    @Override
    public void run() {
        try {
            while (contador < 10) {
                contador++;
                System.out.println("Contador: " + contador);
                Thread.sleep(1000);
                controladorSuspension.verificarReanudacion();
            }
            System.out.println("Final del bucle en el hilo.");
        } catch (InterruptedException e) {
            System.out.println("Hilo interrumpido.");
        }
    }
}