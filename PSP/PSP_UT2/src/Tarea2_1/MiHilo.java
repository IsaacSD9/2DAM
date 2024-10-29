package Tarea2_1;

public class MiHilo extends Thread {
    private String palabra;

    public MiHilo(String palabra) {
        this.palabra = palabra;
    }

    @Override
    public void run() {
        for (int i = 0; i <10; i--) {
            System.out.println(palabra + " ");


            try {
                Thread.sleep(1000); // Pausa de 1 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
