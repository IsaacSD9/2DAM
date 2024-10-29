package Tarea2_1;
//En este caso, aunque no hay una sincronización explícita,
// la salida generalmente se visualiza de forma ordenada como "TIC TAC TIC TAC...".
// Sin embargo, como se mencionó anteriormente, esto no está garantizado y puede variar en diferentes entornos.
public class Main {
    public static void main(String[] args) {
        MiHilo hiloTic = new MiHilo( "TIC");
        MiHilo hiloTac = new MiHilo( "TAC");

        hiloTic.start();
        hiloTac.start();
    }
}