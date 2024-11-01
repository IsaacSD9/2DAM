package Tarea2_4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MiHilo hiloControlador = new MiHilo();
        hiloControlador.start();
        String comando;
        Scanner entradaUsuario = new Scanner(System.in);


        // Realizamos un bucle para gestionar el estado del hilo
        while (true) {
            System.out.println("Introduce un comando (* para finalizar, P para pausar, C para continuar):");
            comando = entradaUsuario.nextLine();

            if (comando.equals("*")) { // Si el usuario quiere finalizar y ha introducido *
                hiloControlador.detenerHilo();
                break;
            } else if (comando.equals("P")) { // Si el usuario quiere pausar el hilo y ha introducido P
                hiloControlador.pausarHilo();
                System.out.println("Hilo en pausa.");
            } else if (comando.equals("C")) { // Si el usuario quiere reanudar el hilo y ha introducido C
                hiloControlador.continuarHilo();
                System.out.println("Hilo reanudado.");
            }
        }

        // Imprime el valor del contador al finalizar la ejecución
        System.out.println("El valor del contador final es: " + hiloControlador.obtenerValorContador());
        System.out.println("Programa finalizado");
    }
}
