package Ejercicio_1;

public class MiHilo extends Thread {
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

