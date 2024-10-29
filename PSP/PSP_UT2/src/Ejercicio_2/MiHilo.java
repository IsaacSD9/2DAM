package Ejercicio_2;

public class MiHilo implements Runnable {
    private String mensaje;

    public MiHilo(String mensaje) {
        this.mensaje = mensaje;
    }

    //Si utilizamos el metodo

    @Override
    public void run() {
        try {
            // Espera un tiempo proporcional al identificador del hilo
            Thread.sleep(Thread.currentThread().getId() * 1000);
            System.out.println(" (Hola mundo: " +mensaje +  Thread.currentThread().getId() + ")");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

