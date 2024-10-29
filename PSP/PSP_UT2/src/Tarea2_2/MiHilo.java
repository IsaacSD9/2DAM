package Tarea2_2;

public class MiHilo implements Runnable {
    private String palabra;

    public MiHilo(String palabra) {
        this.palabra = palabra;
    }

    @Override
    public void run() {

            System.out.println(palabra + " ");


            try {
                Thread.sleep(1000); // Pausa de 1 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

